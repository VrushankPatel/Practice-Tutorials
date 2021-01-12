package org.rabbitmqdemo;


import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import org.apache.commons.lang3.RandomStringUtils;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;

public class Receiver {
    private final static String QUEUE_NAME = "sample_queue";

    public static void main(String[] args) {
        ConnectionFactory factory = new ConnectionFactory();

        // in below line, we'll establish connection to our rabbitmq server.
        // we'll provide hostname, it'll try to connect to port 15672 automatically.
        factory.setHost("winterfell.ml");
        try (
                Connection connection = factory.newConnection();
                Channel channel = connection.createChannel()
        ) {
            // now, let's declare queue name
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

            // let's use java 8 feature to create callback function,
            // this function will be called after every messages received.
            DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                String message = new String(delivery.getBody(), "UTF-8");
                System.out.println(" [x] Received '" + message + "'");
            };
            while(true) {
                channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> { });
            }

        } catch (TimeoutException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        };

    }
}
