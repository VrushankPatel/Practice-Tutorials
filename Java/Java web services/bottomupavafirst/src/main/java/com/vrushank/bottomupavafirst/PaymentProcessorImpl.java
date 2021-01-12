package com.vrushank.bottomupavafirst;

import com.vrushank.bottomupavafirst.PaymentProcessor;
import com.vrushank.bottomupavafirst.dto.PaymentProcessorRequest;
import com.vrushank.bottomupavafirst.dto.PaymentProcessorResponse;

public class PaymentProcessorImpl implements PaymentProcessor {

	public PaymentProcessorResponse processPayment(PaymentProcessorRequest paymentProcessorRequest) {
		PaymentProcessorResponse paymentProcessorResponse = new PaymentProcessorResponse();

		// here, we'll validate the Credit card number
		// if number is not valid, we'll throw exception, so the exception will be translated to a soap fault
		// this SOAP fault will carry the exception message to destination, and there, it will be converted to exception again

		if (paymentProcessorRequest.getCreditCardInfo().getCardNumber() == null || paymentProcessorRequest.getCreditCardInfo().getCardNumber().length() == 0){
			throw new RuntimeException("Invalid Card Number"); //  this Exception will be translated to SOAP fault.
		}

		// Business Logic or a call to a Business Logic Class Goes Here.
		paymentProcessorResponse.setResult(true);
		return paymentProcessorResponse;
	}

}
