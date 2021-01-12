package org.rabbitmqdemo;


import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Receiver {
    private final static String QUEUE_NAME = "sample_queue";

    public static void main(String[] args) {
        ConnectionFactory factory = new ConnectionFactory();

        // in below line, we'll establish connection to our rabbitmq server.
        // we'll provide hostname, it'll try to connect to port 15672 automatically.
        factory.setHost("winterfell.ml");
        try (
                final Connection connection = factory.newConnection();
                final Channel channel = connection.createChannel()
        ) {
            // now, let's declare queue name
            // this time, we'll keep durability to true
            channel.queueDeclare(QUEUE_NAME, true, false, false, null);
            System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

            channel.basicQos(1);

            // this function will be called after every messages received.
            DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                String message = new String(delivery.getBody(), "UTF-8");
                System.out.println(" [x] Received '" + message + "'");
                try {
                    doWork(message);
                } finally {
                    System.out.println(" [x] Done");
                    channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
                }
            };
            while(true) {
                channel.basicConsume(QUEUE_NAME, false, deliverCallback, consumerTag -> { });
            }

        } catch (TimeoutException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        };
    }
    private static void doWork(String task) {
        for (char ch : task.toCharArray()) {
            if (ch == '.') {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException _ignored) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}
