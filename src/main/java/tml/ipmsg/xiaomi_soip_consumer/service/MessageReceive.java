package tml.ipmsg.xiaomi_soip_consumer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import  tml.ipmsg.xiaomi_soip.entity.*;
import tml.ipmsg.xiaomi_soip.model.WebRequest;
import tml.ipmsg.xiaomi_soip_consumer.entity.DeliveryFailed;
import tml.ipmsg.xiaomi_soip_consumer.entity.Message;
import tml.ipmsg.xiaomi_soip_consumer.repository.DeliveryFailedretry;
import tml.ipmsg.xiaomi_soip_consumer.repository.MessageRepository;

@Service
public class MessageReceive {
	@Autowired
	DeliveryFailedretry deliverfailedretrydata;
	@Autowired
	MessageSender rabbitMQSender;
	@Autowired
	MessageRepository messageRepository;
	@Scheduled(fixedRate = 10000)
	public void getdataToRetry()
	{System.out.println("scheduler started.");
	Iterable<DeliveryFailed> retrydata=	deliverfailedretrydata.findAllByProcessstatus(0);

	retrydata.forEach(data -> {
		try {
			Message msg=	messageRepository.findAllByMsgId(data.getMsgid());
			SendRetrydataToRabbitMQ(msg);
			DeliveryFailed deliveryfailed=new DeliveryFailed();
			deliveryfailed.setId(data.getId());
			deliveryfailed.setAccount(data.getAccount());
			deliveryfailed.setBizextra(data.getBizextra());
			deliveryfailed.setBizmsgid(data.getBizmsgid());
			deliveryfailed.setBiznum(data.getBiznum());
			deliveryfailed.setMessage(data.getMessage());
			deliveryfailed.setMsgid(data.getMsgid());
			deliveryfailed.setPhone(data.getPhone());

			deliveryfailed.setReciepientid(data.getReciepientid());
			deliveryfailed.setTotalPdu(data.getTotalPdu());
			deliveryfailed.setProcessstatus(1);
			deliverfailedretrydata.save(deliveryfailed);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	});  
	}

	public void SendRetrydataToRabbitMQ(Message deliveryfailed) throws Exception
	{
		WebRequest webrequest=new WebRequest();
		webrequest.setCorelationid(deliveryfailed.getBizExtra());
		webrequest.setFrom(deliveryfailed.getBizNum());
		//webrequest.setID(deliveryfailed.);
		webrequest.setMessage(deliveryfailed.getContent());
		webrequest.setMsisdn(deliveryfailed.getPhone());
		webrequest.setPassword(deliveryfailed.getDlttemplateid());
		webrequest.setTemplateid(deliveryfailed.getDlttemplateid());
		webrequest.setUnicode(deliveryfailed.getUnicode());
		webrequest.setUsername(String.valueOf( deliveryfailed.getClient_id()));
		webrequest.setUuid(deliveryfailed.getMsgId());
		rabbitMQSender.SendmessageToPro(webrequest);
	}

}
