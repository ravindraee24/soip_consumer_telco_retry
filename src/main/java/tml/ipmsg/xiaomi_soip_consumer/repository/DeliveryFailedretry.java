package tml.ipmsg.xiaomi_soip_consumer.repository;

import org.springframework.data.repository.CrudRepository;

import tml.ipmsg.xiaomi_soip_consumer.entity.DeliveryFailed;;

public interface DeliveryFailedretry extends  CrudRepository<DeliveryFailed, Long >   {

public	Iterable<DeliveryFailed> findAllByProcessstatus(int i);

}
