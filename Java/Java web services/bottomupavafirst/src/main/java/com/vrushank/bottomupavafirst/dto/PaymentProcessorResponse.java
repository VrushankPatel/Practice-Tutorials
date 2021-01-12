package com.vrushank.bottomupavafirst.dto;

import javax.xml.bind.annotation.XmlType;

// below annotation will make the complex type for this class.
@XmlType(name = "PaymentProcessorResponse") // by default, it'll take the same name as class name
// we'll not use field based xml accessor here because all the fields in this class are optional, not required.

public class PaymentProcessorResponse {

	private boolean result;

	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}
}
