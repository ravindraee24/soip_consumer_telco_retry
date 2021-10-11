package tml.ipmsg.xiaomi_soip_consumer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import tml.ipmsg.xiaomi_soip.entity.client;
import tml.ipmsg.xiaomi_soip_consumer.serviceInterface.IClientCache;



@Service
public class ClientCache implements IClientCache{
	 public static final String HASH_KEY = "ClientDetail";
	    @Autowired
	    private RedisTemplate template;

	    public String save(String key){
	        template.opsForHash().put(HASH_KEY,"Token",key);
	        return key;
	    }
	    public client saveById(client client,String Id){
	        template.opsForHash().put(HASH_KEY,"ClientDetail:"+Id,client);
	        return client;
	    }
	    
	    public client saveByname(client client,String Name){
	        template.opsForHash().put(HASH_KEY,"ClientDetail:"+Name,client);
	        return client;
	    }

	    public List<String> findAll(){
	        return template.opsForHash().values(HASH_KEY);
	    }
	    public List<String> findById(String ID){
	        return template.opsForHash().values("ClientDetail:"+ID);
	    }
	    
	    public tml.ipmsg.xiaomi_soip.entity.client findByName(String ClientName,String hashKey){    
	    	      
	    	   
	    	return (client) template.opsForValue().get( ClientName+"::"+hashKey );
	    	//return (client) template.opsForHash().get(ClientName, hashKey);
	    }
}