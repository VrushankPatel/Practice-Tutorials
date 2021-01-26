package com.vrushank.wsdlwsfirst;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;

@Configuration
public class WebServiceConfig {

    @Autowired
    private Bus bus;

    @Bean
    public Endpoint endPoint(){
        // now we'll create endpoint
        Endpoint endpoint = new EndpointImpl(bus, new CustomerOrdersWsImpl());

        // below line is the exact endpoint where we'll access out webservice
        endpoint.publish("/customerorderwservice");
        return endpoint;
    }
}

