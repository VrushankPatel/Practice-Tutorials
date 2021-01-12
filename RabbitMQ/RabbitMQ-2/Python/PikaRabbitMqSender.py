# in this program, we'll send the message via exchange to queue.
import pika
import random
import string
import time

# In this part, we'll distribute the task among workers,
# in the old program, all the receivers were receiving the same message,
# here, the tasks will be distributed among all receivers,
# so, if i send message as a,b,c,d,e,f, among 3 receivers, then one receiver will show 1, then second rec.. will show 2 and so on.
connection = pika.BlockingConnection(
    pika.ConnectionParameters(host='winterfell.ml'))
channel = connection.channel()

channel.queue_declare(queue='sample_queue', durable=True)


def get_random_string(length):
    return ''.join(random.choices(string.ascii_uppercase + string.digits, k=length))


while True:
    message = get_random_string(8)
    print(f'sent ${message}')
    channel.basic_publish(exchange='', routing_key='sample_queue',
                          body=message, properties=pika.BasicProperties(
                              # make message persistent, so it can't be repeated for another queue.
                              delivery_mode=2,
                          ))
    time.sleep(0.3)

print("Message is sent")

connection.close()
