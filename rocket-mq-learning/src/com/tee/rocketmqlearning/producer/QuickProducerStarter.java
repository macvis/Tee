package com.tee.rocketmqlearning.producer;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

/**
 * @author youchao.wen
 * @date 2019/12/14.
 */
public class QuickProducerStarter {
    @lombok.SneakyThrows
    public static void main(String[] args) throws Exception {
        DefaultMQProducer producer = new DefaultMQProducer("demo");
        producer.setNamesrvAddr("demo address");
        producer.start();

        Message msg = new Message();
        msg.setTopic("demo");
        msg.setTags("tagA");
        msg.setKeys("keyA");
        msg.setBody("message".getBytes());

        producer.send(msg);

        producer.send(msg, new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {

            }

            @Override
            public void onException(Throwable e) {

            }
        });

        producer.shutdown();
    }
}
