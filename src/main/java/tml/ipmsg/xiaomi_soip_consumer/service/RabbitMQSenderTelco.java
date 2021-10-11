package tml.ipmsg.xiaomi_soip_consumer.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import tml.ipmsg.xiaomi_soip.model.WebRequest;


@Service
public class RabbitMQSenderTelco {
	@Autowired
	private AmqpTemplate amqpTemplate;
	
	@Value("${jsa.rabbitmq.exchange}")
	private String exchange;
	
	@Value("${javainuse.rabbitmq.routingkey}")
	private String routingkey;
	

	
	public String send(WebRequest webRequest) throws Exception{		
		amqpTemplate.convertAndSend(exchange, routingkey, webRequest);
		
		return "DONE";	    
	}
}
