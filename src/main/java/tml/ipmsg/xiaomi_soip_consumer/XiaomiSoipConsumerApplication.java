package tml.ipmsg.xiaomi_soip_consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
@EnableRabbit
@SpringBootApplication
@EnableScheduling
public class XiaomiSoipConsumerApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(XiaomiSoipConsumerApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(XiaomiSoipConsumerApplication.class, args);
		LOGGER.info("---------------SOIP consumer started------------------------");
	}

}
