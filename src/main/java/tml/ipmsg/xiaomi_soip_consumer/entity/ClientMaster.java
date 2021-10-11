package tml.ipmsg.xiaomi_soip_consumer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity()
@Table(name = "yulore_client_master")
public class ClientMaster {
	@Id
	private long id ;
	  private String clientname ;
	  private String username;
	  private int Xiomi_route ;
	  
	   private boolean isactive;
	  
	  private String sms_platform;
	  @Column(name = "credentials", columnDefinition = "text")
	  private String credentials;
	 
	  private String xiaomi_feature;

	public String getClientname() {
		return clientname;
	}

	public void setClientname(String clientname) {
		this.clientname = clientname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getXiomi_route() {
		return Xiomi_route;
	}

	public void setXiomi_route(int xiomi_route) {
		Xiomi_route = xiomi_route;
	}

	

	public boolean getIsactive() {
		return isactive;
	}

	public void setIsactive(boolean isactive) {
		this.isactive = isactive;
	}

	
	public String getSms_platform() {
		return sms_platform;
	}

	public void setSms_platform(String sms_platform) {
		this.sms_platform = sms_platform;
	}

	public String getCredentials() {
		return credentials;
	}

	public void setCredentials(String credentials) {
		this.credentials = credentials;
	}

	public String getXiaomi_feature() {
		return xiaomi_feature;
	}

	public void setXiaomi_feature(String xiaomi_feature) {
		this.xiaomi_feature = xiaomi_feature;
	}
}
