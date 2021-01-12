package com.vrushank.bottomupavafirst.dto;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "PaymentProcessorRequest") // by default, it'll take the same name as class name
@XmlAccessorType(XmlAccessType.FIELD)	// for fields level
public class PaymentProcessorRequest {

	@XmlElement(name = "creditCardInfo", required = true)
	private CreditCardInfo creditCardInfo;

	@XmlElement(name = "amount")
	private Double amount;

	public CreditCardInfo getCreditCardInfo() {
		return creditCardInfo;
	}

	public void setCreditCardInfo(CreditCardInfo creditCardInfo) {
		this.creditCardInfo = creditCardInfo;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

}
