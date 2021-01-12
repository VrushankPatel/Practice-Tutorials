# in this program, we'll send the message via exchange to queue.
import pika
import random
import string
import time

# in below line, we'll establish connection to our rabbitmq server.
# we'll provide hostname, it'll try to connect to port 15672 automatically.
connection = pika.BlockingConnection(
    pika.ConnectionParameters('winterfell.ml'))

channel = connection.channel()

# now, let's declare queue name
channel.queue_declare(queue='sample_queue')


def get_random_string(length):
    return ''.join(random.choices(string.ascii_uppercase + string.digits, k=length))


# here, default exchange is identified by empty string which will be our first parameter.
# The label or routing key describes the payload and the RabbitMQ messaging system uses this to determine who will receive a copy of your message.
# body parameter contains the message body.
counter = 1
while True:
    message = get_random_string(8)
    print(message)
    channel.basic_publish(exchange='', routing_key='sample_queue',
                          body=message)
    # time.sleep(1)

print("Message is sent")

connection.close()
