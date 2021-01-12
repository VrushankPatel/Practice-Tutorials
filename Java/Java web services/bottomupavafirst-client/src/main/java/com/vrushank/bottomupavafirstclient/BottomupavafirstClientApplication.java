package com.vrushank.bottomupavafirstclient;


import com.vrushank.bottomupavafirst.PaymentProcessor;
import com.vrushank.bottomupavafirst.PaymentProcessorImplService;
import com.vrushank.bottomupavafirst.PaymentProcessorRequest;
import com.vrushank.bottomupavafirst.PaymentProcessorResponse;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.endpoint.Endpoint;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.ws.security.wss4j.WSS4JOutInterceptor;
import org.apache.wss4j.dom.WSConstants;
import org.apache.wss4j.dom.handler.WSHandlerConstants;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class BottomupavafirstClientApplication {

	public static void main(String[] args)  throws MalformedURLException {
		PaymentProcessorImplService service = new PaymentProcessorImplService(new URL("http://localhost:8080/javafirstws/paymentProcessor?wsdl"));
		PaymentProcessor port = service.getPaymentProcessorImplPort();

		Client client = ClientProxy.getClient(port);
		Endpoint endpoint = client.getEndpoint();

		Map<String, Object> props = new HashMap<>();

		props.put(WSHandlerConstants.ACTION, WSHandlerConstants.USERNAME_TOKEN);
		props.put(WSHandlerConstants.USER, "cxf");
		props.put(WSHandlerConstants.PASSWORD_TYPE, WSConstants.PW_TEXT);
		props.put(WSHandlerConstants.PW_CALLBACK_CLASS, UTPasswordCallback.class.getName());

		WSS4JOutInterceptor wss4JOutInterceptor = new WSS4JOutInterceptor(props);
		endpoint.getOutInterceptors().add(wss4JOutInterceptor);

		PaymentProcessorResponse response = port.processPayment(new PaymentProcessorRequest());
		System.out.println(response.isResult());
	}

}
