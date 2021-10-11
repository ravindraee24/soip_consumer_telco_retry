package tml.ipmsg.xiaomi_soip_consumer.Dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tml.ipmsg.xiaomi_soip_consumer.entity.Message;
import tml.ipmsg.xiaomi_soip_consumer.repository.MessageRepository;
@Service
public  class MessageDao  {
@Autowired 
private MessageRepository messageReposiyory;

public Message Save(Message entity) {
return	messageReposiyory.save(entity);
}

	

	
}
