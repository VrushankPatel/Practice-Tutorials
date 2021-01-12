package com.vrushank.cxfdemo.hellowebservice.config;

import com.vrushank.cxfdemo.hellowebservice.HelloWs;
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
        Endpoint endpoint = new EndpointImpl(bus, new HelloWs());
        endpoint.publish("/hello");
        return endpoint;
    }
}
