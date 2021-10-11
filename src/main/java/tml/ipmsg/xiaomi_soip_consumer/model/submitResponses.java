package tml.ipmsg.xiaomi_soip_consumer.model;

public class submitResponses {
	 private String transactionId;
	 private String state;
	 private String description;
	 private float pdu;
	 private String corelationId;


	 // Getter Methods 

	 public String getTransactionId() {
	  return transactionId;
	 }

	 public String getState() {
	  return state;
	 }

	 public String getDescription() {
	  return description;
	 }

	 public float getPdu() {
	  return pdu;
	 }

	 public String getCorelationId() {
	  return corelationId;
	 }

	 // Setter Methods 

	 public void setTransactionId(String transactionId) {
	  this.transactionId = transactionId;
	 }

	 public void setState(String state) {
	  this.state = state;
	 }

	 public void setDescription(String description) {
	  this.description = description;
	 }

	 public void setPdu(float pdu) {
	  this.pdu = pdu;
	 }

	 public void setCorelationId(String corelationId) {
	  this.corelationId = corelationId;
	 }

	@Override
	public String toString() {
		return "submitResponses [transactionId=" + transactionId + ", state=" + state + ", description=" + description
				+ ", pdu=" + pdu + ", corelationId=" + corelationId + "]";
	}
	}