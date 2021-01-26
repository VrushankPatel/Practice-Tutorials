package com.flurken.webservices.controller;

import com.flurken.webservices.bean.HelloWorldBean;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloWorldController {
//    @RequestMapping(method = RequestMethod.GET, path = "/hello-world") // Insted of this, we can use direct GetMapping as below.
    @GetMapping(path = "/hello-world") // Try the same for POST, PUT, DELETE also.
    public String helloWorld(){
        return "Hello World";
    }

    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean helloWorldBean(){
        // here, the toString method of HelloWorld will be called, but make sure there is a getter in HelloWorldBean class, otherwise response will be as error.
        // this response will automatically be converted to JSON format, all the class variables-values will converted to json attributes-values.
        return new HelloWorldBean("Hello World");
    }

    @GetMapping(path = "/hello-world/path-var/{name}")
    public HelloWorldBean helloWorldWithPathVariable(@PathVariable String name){
        // here, we'll pass the path variable.
        return new HelloWorldBean(String.format("Hello World, %s", name));
    }
}
