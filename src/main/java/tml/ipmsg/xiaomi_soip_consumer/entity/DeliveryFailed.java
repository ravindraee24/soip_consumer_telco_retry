package tml.ipmsg.xiaomi_soip_consumer.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity()
@Table(name = "yulore_delivery_failed") 
public class DeliveryFailed {
@Id
	private long id; 
	private String  account; 
	private String  message; 
	private String  reciepientid; 
	private String  description ;
	private String  totalpdu ;
	private String  callbacktype; 
	private String  errcode ;
	
	private String  phone ;
	private String   msgid ;
	private String   bizmsgid ;
	private String   bizextra ;
	private String   status ;
	private String   biznum ;
	private String   msgtype ;
	private String   reversalstatus ;
	  
	private int   processstatus ;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getReciepientid() {
		return reciepientid;
	}

	public void setReciepientid(String reciepientid) {
		this.reciepientid = reciepientid;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTotalPdu() {
		return totalpdu;
	}

	public void setTotalPdu(String totalPdu) {
		this.totalpdu = totalPdu;
	}

	public String getCallbacktype() {
		return callbacktype;
	}

	public void setCallbacktype(String callbacktype) {
		this.callbacktype = callbacktype;
	}

	public String getErrcode() {
		return errcode;
	}

	public void setErrcode(String errcode) {
		this.errcode = errcode;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMsgid() {
		return msgid;
	}

	public void setMsgid(String msgid) {
		this.msgid = msgid;
	}

	public String getBizmsgid() {
		return bizmsgid;
	}

	public void setBizmsgid(String bizmsgid) {
		this.bizmsgid = bizmsgid;
	}

	public String getBizextra() {
		return bizextra;
	}

	public void setBizextra(String bizextra) {
		this.bizextra = bizextra;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getBiznum() {
		return biznum;
	}

	public void setBiznum(String biznum) {
		this.biznum = biznum;
	}

	public String getMsgtype() {
		return msgtype;
	}

	public void setMsgtype(String msgtype) {
		this.msgtype = msgtype;
	}

	public String getReversalstatus() {
		return reversalstatus;
	}

	public void setReversalstatus(String reversalstatus) {
		this.reversalstatus = reversalstatus;
	}

	public int getProcessstatus() {
		return processstatus;
	}

	public void setProcessstatus(int processstatus) {
		this.processstatus = processstatus;
	}
}
