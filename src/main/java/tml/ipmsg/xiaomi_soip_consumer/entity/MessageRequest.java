package tml.ipmsg.xiaomi_soip_consumer.entity;


	

	import javax.persistence.Entity;
	import javax.persistence.Table;
	import javax.persistence.Id;
	import javax.persistence.Column;;
	@Entity()
	@Table(name = "yulore_message_Request") 
	public class MessageRequest {
		@Id
		private long id;
		private String bizNum;
		private String phone;
		private String content;
		@Column(name="bizMsgId")
		private String bizMsgId;
		@Column(name="bizExtra")
		private String bizExtra;
		private String dlttemplateid;
		private String client_id;
		private String msgId;
		private String status;
		private String credit_used;
		private String response;
		private String unicode;
		private String pdujsonFormat;
		private String delivery_status;
		public String getBizNum() {
			return bizNum;
		}
		public void setBizNum(String bizNum) {
			this.bizNum = bizNum;
		}
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}
		public String getBizMsgId() {
			return bizMsgId;
		}
		public void setBizMsgId(String bizMsgId) {
			this.bizMsgId = bizMsgId;
		}
		public String getBizExtra() {
			return bizExtra;
		}
		public void setBizExtra(String bizExtra) {
			this.bizExtra = bizExtra;
		}
		public String getDlttemplateid() {
			return dlttemplateid;
		}
		public void setDlttemplateid(String dlttemplateid) {
			this.dlttemplateid = dlttemplateid;
		}
		public String getClient_id() {
			return client_id;
		}
		public void setClient_id(String l) {
			this.client_id = l;
		}
		public String getMsgId() {
			return msgId;
		}
		public void setMsgId(String msgId) {
			this.msgId = msgId;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public String getCredit_used() {
			return credit_used;
		}
		public void setCredit_used(String credit_used) {
			this.credit_used = credit_used;
		}
		public String getResponse() {
			return response;
		}
		public void setResponse(String response) {
			this.response = response;
		}
		public String getPdujsonFormat() {
			return pdujsonFormat;
		}
		public void setPdujsonFormat(String pdujsonFormat) {
			this.pdujsonFormat = pdujsonFormat;
		}
		public String getDelivery_status() {
			return delivery_status;
		}
		public void setDelivery_status(String delivery_status) {
			this.delivery_status = delivery_status;
		}
		@Override
		public String toString() {
			return "Message [id=" + id + ", bizNum=" + bizNum + ", phone=" + phone + ", content=" + content + ", bizMsgId="
					+ bizMsgId + ", bizExtra=" + bizExtra + ", dlttemplateid=" + dlttemplateid + ", client_id=" + client_id
					+ ", msgId=" + msgId + ", status=" + status + ", credit_used=" + credit_used + ", response=" + response
					+ ", pdujsonFormat=" + pdujsonFormat + ", delivery_status=" + delivery_status + "]";
		}
		public String getUnicode() {
			return unicode;
		}
		public void setUnicode(String unicode) {
			this.unicode = unicode;
		}
	}
