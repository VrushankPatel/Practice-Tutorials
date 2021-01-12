package org.rabbitmqdemo;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;
import org.apache.commons.lang3.RandomStringUtils;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;

// In this part, we'll distribute the task among workers,
// in the old program, all the receivers were receiving the same message,
// here, the tasks will be distributed among all receivers,
// so, if i send message as a,b,c,d,e,f, among 3 receivers, then one receiver will show 1, then second rec.. will show 2 and so on.

public class Sender {

    private static final String TASK_QUEUE_NAME = "sample_queue";

    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();

        Scanner sc = new Scanner(System.in);

        // in below line, we'll establish connection to our rabbitmq server.
        // we'll provide hostname, it'll try to connect to port 15672 automatically.
        factory.setHost("winterfell.ml");
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            channel.queueDeclare(TASK_QUEUE_NAME, true, false, false, null);

            String message;
            while(true){
                System.out.print("Enter your Message (leave blank to stop and exit) : ");
                message = sc.nextLine();

                // here, default exchange is identified by empty string which will be our first parameter.
                // The label or routing key describes the payload and the RabbitMQ messaging system uses this to determine who will receive a copy of your message.
                // body parameter contains the message body.
                if (!message.isEmpty()) {
                    // now in basic Publish, we'll provide a prooperty that keeps the message persist.
                    // So, the messages can be distributed among multiple receivers.
                    channel.basicPublish("", TASK_QUEUE_NAME,
                            MessageProperties.PERSISTENT_TEXT_PLAIN,
                            message.getBytes("UTF-8"));
                    System.out.println(" [x] Sent '" + message + "'");
                    Thread.sleep(10);
                }else {
                    break;
                }
            }
        }
    }
}
