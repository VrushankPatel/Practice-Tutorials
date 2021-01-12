# in this program, we'll receive the message from queue.
import pika
import sys
import os
import time

# In this part, we'll distribute the task among workers,
# in the old program, all the receivers were receiving the same message,
# here, the tasks will be distributed among all receivers,
# so, if i send message as a,b,c,d,e,f, among 3 receivers, then one receiver will show 1, then second rec.. will show 2 and so on.


def main():
    # In this part, we'll distribute the task among workers,
    # in the old program, all the receivers were receiving the same message,
    # here, the tasks will be distributed among all receivers,
    # so, if i send message as a,b,c,d,e,f, among 3 receivers, then one receiver will show 1, then second rec.. will show 2 and so on.

    connection = pika.BlockingConnection(
        pika.ConnectionParameters(host='winterfell.ml'))
    channel = connection.channel()

    # this time, the queue will be durable, so we'll set durable = True
    channel.queue_declare(queue='sample_queue', durable=True)
    print(' [*] Waiting for messages. To exit press CTRL+C')

    def callback(ch, method, properties, body):
        print(" [x] Received %r" % body.decode())
        time.sleep(body.count(b'.'))
        print(" [x] Done")
        ch.basic_ack(delivery_tag=method.delivery_tag)

    channel.basic_qos(prefetch_count=1)
    channel.basic_consume(queue='sample_queue', on_message_callback=callback)

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
