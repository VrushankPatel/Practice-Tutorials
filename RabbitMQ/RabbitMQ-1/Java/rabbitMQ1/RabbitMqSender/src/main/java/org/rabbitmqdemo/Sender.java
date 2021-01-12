package org.rabbitmqdemo;


import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.apache.commons.lang3.RandomStringUtils;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Sender {
    private final static String QUEUE_NAME = "sample_queue";

    public static void main(String[] args) {
        ConnectionFactory factory = new ConnectionFactory();
        // Scanner sc = new Scanner(System.in);

        // in below line, we'll establish connection to our rabbitmq server.
        // we'll provide hostname, it'll try to connect to port 15672 automatically.
        factory.setHost("winterfell.ml");
        try (
                Connection connection = factory.newConnection();
                Channel channel = connection.createChannel()
        ) {
            // now, let's declare queue name
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            String message;
            while(true) {
                // System.out.print("Enter your Message (leave blank to stop and exit) : ");
                // message = sc.nextLine();

                message = RandomStringUtils.randomAlphanumeric(17).toUpperCase();

                // here, default exchange is identified by empty string which will be our first parameter.
                // The label or routing key describes the payload and the RabbitMQ messaging system uses this to determine who will receive a copy of your message.
                // body parameter contains the message body.
                if (!message.isEmpty()) {
                    channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
                    System.out.println(" [x] Sent '" + message + "'");
//                    Thread.sleep(10);
                }else {
                    connection.close();
                    break;
                }
            }

        } catch (TimeoutException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
