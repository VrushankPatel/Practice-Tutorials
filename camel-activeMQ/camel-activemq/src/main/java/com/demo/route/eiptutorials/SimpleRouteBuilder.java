package com.demo.route.eiptutorials;

import org.apache.camel.builder.RouteBuilder;

public class SimpleRouteBuilder extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		from("file:C:/camelDemoFolder").split().tokenize("\n").to("jms:queue:sampleQueue");
		
	}

}
