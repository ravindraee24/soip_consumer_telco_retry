package tml.ipmsg.xiaomi_soip.model;

import java.io.Serializable;

public class WebRequest implements Serializable{

private static final long serialVersionUID = 1L;
private long ID;
private String username;
private String password;
private String From;
private String templateid;
private String corelationid;
private String msisdn;
private String message;
private String uuid;
private String unicode;
public long getID() {
	return ID;
}
public void setID(long iD) {
	ID = iD;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getFrom() {
	return From;
}
public void setFrom(String from) {
	From = from;
}
public String getTemplateid() {
	return templateid;
}
public void setTemplateid(String templateid) {
	this.templateid = templateid;
}
public String getCorelationid() {
	return corelationid;
}
public void setCorelationid(String corelationid) {
	this.corelationid = corelationid;
}
public String getMsisdn() {
	return msisdn;
}
public void setMsisdn(String msisdn) {
	this.msisdn = msisdn;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public String getUuid() {
	return uuid;
}
public void setUuid(String uuid) {
	this.uuid = uuid;
}
public static long getSerialversionuid() {
	return serialVersionUID;
}
@Override
public String toString() {
	return "WebRequest [ID=" + ID + ", username=" + username + ", password=" + password + ", From=" + From
			+ ", templateid=" + templateid + ", corelationid=" + corelationid + ", msisdn=" + msisdn + ", message="
			+ message + ", uuid=" + uuid + "]";
}
public String getUnicode() {
	return unicode;
}
public void setUnicode(String unicode) {
	this.unicode = unicode;
}

}
