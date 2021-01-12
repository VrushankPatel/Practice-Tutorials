package com.vrushank.bottomupavafirst.dto;

import javax.xml.bind.annotation.XmlType;
import java.util.Date;

@XmlType(name = "CreditCardInfo") // by default, it'll take the same name as class name
// we'll not use field based xml accessor here because all the fields in this class are optional, not required.
public class CreditCardInfo {

	String cardNumber;
	private Date expirtyDate;
	String firstName;
	String lastName;
	String secCode;
	String Address;

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSecCode() {
		return secCode;
	}

	public void setSecCode(String secCode) {
		this.secCode = secCode;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public Date getExpirtyDate() {
		return expirtyDate;
	}

	public void setExpirtyDate(Date expirtyDate) {
		this.expirtyDate = expirtyDate;
	}

}
