package tml.ipmsg.xiaomi_soip_consumer.repository;

import org.springframework.data.repository.CrudRepository;


import tml.ipmsg.xiaomi_soip_consumer.entity.Message;


public interface MessageRepository extends  CrudRepository<Message, Long >   {
	public	Message findAllByMsgId(String msgid);
}
