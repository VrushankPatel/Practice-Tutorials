package com.demo.route.eiptutorials;

import org.apache.camel.builder.RouteBuilder;

public class ContentBasedRoutingPattern extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		from("file:C:/camelDemoFolder").split().tokenize("\n").to("jms:queue:sampleQueue");
		
		// here, we'll take the data from sampleQueue, and check it like if else ledder.
		// if it contains sampleQueue1, then we'll pass it to new Queue sampleQueue1, same for 2 and 3, and if it contains neither of them, then
		// we'll pass it to new queue otherwise queue.
		from("jms:queue:sampleQueue") 
        	.choice()
        		.when(body().contains("sampleCamel1"))
        			.to("jms:queue:sampleCamel1")
        		.when(body().contains("sampleCamel2"))
        			.to("jms:queue:sampleCamel2")
        		.when(body().contains("sampleCamel3"))
        			.to("jms:queue:sampleCamel3")
        		.otherwise()
        			.to("jms:queue:otherwise");
	}
	
}
