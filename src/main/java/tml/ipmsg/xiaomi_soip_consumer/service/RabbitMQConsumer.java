package tml.ipmsg.xiaomi_soip_consumer.service;

import java.io.IOException;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import tml.ipmsg.xiaomi_soip.model.WebRequest;
import tml.ipmsg.xiaomi_soip_consumer.Dao.MessageDao;
import tml.ipmsg.xiaomi_soip_consumer.entity.Message;

@Service
public class RabbitMQConsumer {
	private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQConsumer.class);
	@Autowired
	private AmqpTemplate amqpTemplate;
	@Autowired
	private MessageSender messageSender;
	@Autowired
	private MessageDao messageDao;
	@Value("${badreq.rabbitmq.exchange}")
	private String exchange;
	
	@Value("${badreq.rabbitmq.routingkey}")
	private String routingkey;
	
	@Value("${pro.url}")
	private String proURL;
	
	@Value("${pro.connect.timeout}")
	private int proConnectTimeout;
	
	@Value("${pro.read.timeout}")
	private int proReadTimeout;
	
	@Value("${pro.password}")
	private String proPassword;
	
	@Value("${pro.user}")
	private String proUser;
	
	@Value("${pro.templateId}")
	private String proTemplateId;
	@RabbitListener(queues = "${jsa.rabbitmq.queue}")
	public void recievedMessage(WebRequest webRequest) throws IOException 
	{        
        String proResponse=messageSender.SendmessageToPro(webRequest);
		LOGGER.info("proResponse --- "+proResponse);
		
		//MessageDao.
		if(proResponse !=null && (proResponse.toUpperCase().indexOf("SUBMIT_ACCEPTED") != -1))
		{
			//LOGGER.info("Success::"+corelationId+"::"+recipient+"::"+senderId);
			//LOGGER.error("Success::"+corelationId+"::"+recipient+"::"+senderId);
		}
		else
		{
			LOGGER.info("WebEngageRequest="+webRequest.toString()+"::::proResponse=" + proResponse);
			//LOGGER.error("WebEngageRequest="+webEngageRequestString+"::::proResponse=" + proResponse);
			amqpTemplate.convertAndSend(exchange, routingkey, webRequest);
		}
	}
	
}
