package data.model;

import java.io.Serializable;

public abstract class Payload implements Serializable {
	private static final long serialVersionUID = 7826412956628173147L;
	
	protected String payloadId;

	public String getPayloadId() {
		return payloadId;
	}

	public void setPayloadId(String payloadId) {
		this.payloadId = payloadId;
	}
}