package com.demo.main;

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;

import com.demo.route.eiptutorials.ContentBasedRoutingPattern;
import com.demo.route.eiptutorials.RecipientListPattern;
import com.demo.route.eiptutorials.SimpleRouteBuilder;

public class App {
	public static void main(String[] args) {
//		SimpleRouteBuilder simpleRouteBuilder = new SimpleRouteBuilder();
//		ContentBasedRoutingPattern contentBasedRoutingPattern = new ContentBasedRoutingPattern();
		RecipientListPattern recipientListPattern = new RecipientListPattern();
		
		CamelContext ctx = new DefaultCamelContext();
		
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://0.0.0.0:61616");
		ctx.addComponent("jms", JmsComponent.jmsComponentAutoAcknowledge(connectionFactory));
		
		try {
			ctx.addRoutes(recipientListPattern);
			ctx.start();
			Thread.sleep(5 * 60 * 1000);
			ctx.stop();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
