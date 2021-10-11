package tml.ipmsg.xiaomi_soip.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.redis.core.RedisHash;
@Entity()
@Table(name = "yulore_client_master") 
public class client implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	private long  id;
	private String  clientname ;
	private String   username ;
	
	private String   sms_platform;
	private String   email;
	private String   xiaomi_feature;
	private int   Xiomi_route ;
	private String   valid_ip ;
	private String credentials;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getClientname() {
		return clientname;
	}
	public void setClientname(String clientname) {
		this.clientname = clientname;
	}
	
	public String getSms_platform() {
		return sms_platform;
	}
	public void setSms_platform(String sms_platform) {
		this.sms_platform = sms_platform;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getXiaomi_feature() {
		return xiaomi_feature;
	}
	public void setXiaomi_feature(String xiaomi_feature) {
		this.xiaomi_feature = xiaomi_feature;
	}
	public int getXiomi_route() {
		return Xiomi_route;
	}
	public void setXiomi_route(int xiomi_route) {
		Xiomi_route = xiomi_route;
	}
	public String getValid_ip() {
		return valid_ip;
	}
	public void setValid_ip(String valid_ip) {
		this.valid_ip = valid_ip;
	}
	public String getCredentials() {
		return credentials;
	}
	public void setCredentials(String credentials) {
		this.credentials = credentials;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
}