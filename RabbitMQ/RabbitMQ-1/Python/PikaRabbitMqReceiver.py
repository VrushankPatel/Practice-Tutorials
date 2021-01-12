# in this program, we'll receive the message from queue.
import pika
import sys
import os


def main():
    # in below line, we'll establish connection to our rabbitmq server.
    # we'll provide hostname, it'll try to connect to port 15672 automatically.
    connection = pika.BlockingConnection(
        pika.ConnectionParameters('winterfell.ml'))

    channel = connection.channel()

    # now here, we've to use the same name of the queue used by sender to send the message to queue.
    channel.queue_declare(queue='sample_queue')

    # Receiving messages from the queue is more complex. It works by subscribing a callback function to a queue.
    # Whenever we receive a message, this callback function is called by the Pika library.
    # In our case this function will print on the screen the contents of the message.

    def callback(ch, method, properties, body):
        print(" [x] Received Message : " + body.decode())

    channel.basic_consume(queue='sample_queue',
                          auto_ack=True, on_message_callback=callback)

    print(' [*] Waiting for messages. To exit press CTRL+C')
    channel.start_consuming()


if __name__ == '__main__':
    try:
        main()
    except KeyboardInterrupt:
        print('Interrupted')
        try:
            sys.exit(0)
        except SystemExit:
            os._exit(0)
