package com.demo.route.eiptutorials;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;

public class RecipientListPattern extends RouteBuilder {

	@Override
	public void configure() throws Exception {
	from("file:C:/camelDemoFolder").split().tokenize("\n").to("jms:queue:sampleQueue");
		
		// here, we'll take the data from sampleQueue, split it, and create new queue by that name which is in the splitted data is.
		// for that, we'll use process to process the data, which requires the Procecssor object, it is anonymous class, 
		// so, we've to instantiate by override the process method, in that method, we'll create new queues by splitted data. 
 
		from("jms:queue:sampleQueue") 
		.process(
			new Processor() {
				public void process(Exchange exchange) throws Exception {					
				   String recipient = exchange.getIn().getBody().toString();
				   System.out.println("processed : " + recipient);
				   String recipientQueue="jms:queue:"+recipient;
				   exchange.getIn().setHeader("queue", recipientQueue);		
				}
			}
		).recipientList(header("queue")); // in this line, it'll create new queue

	}
}
