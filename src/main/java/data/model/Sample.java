package data.model;

import java.io.Serializable;

public abstract class Sample implements Serializable {
	private static final long serialVersionUID = 7826412956628173147L;
	
	protected String sampleId;

	public String getSampleId() {
		return sampleId;
	}

	public void setPayloadId(String sampleId) {
		this.sampleId = sampleId;
	}
}