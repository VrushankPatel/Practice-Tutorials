package com.vrushank.cxfdemo.hellowebservice;

import org.apache.cxf.feature.Features;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
@Features(features = "org.apache.cxf.feature.LoggingFeature")
public class HelloWs {
    @WebMethod
    public String Hello(){
        return "Hello there";
    }
}
