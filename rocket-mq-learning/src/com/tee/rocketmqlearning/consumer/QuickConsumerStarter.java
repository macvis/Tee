package com.tee.rocketmqlearning.consumer;

import com.alibaba.rocketmq.remoting.common.RemotingHelper;
import lombok.SneakyThrows;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerOrderly;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;

/**
 * @author youchao.wen
 * @date 2019/12/14.
 */
public class QuickConsumerStarter {
    @SneakyThrows
    public static void main(String[] args) {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("demo");
        consumer.setNamesrvAddr("address");
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
        consumer.subscribe("topic", "*");
        consumer.registerMessageListener((MessageListenerOrderly) (msgs, context) -> {
            MessageExt mesgExt = msgs.get(0);
            try {
                mesgExt.getTopic();
                String message = new String(mesgExt.getBody(), RemotingHelper.DEFAULT_CHARSET);
                System.out.println("message -> " + message);
            } catch (Exception e) {
                e.printStackTrace();
                mesgExt.getReconsumeTimes();
                return ConsumeOrderlyStatus.SUSPEND_CURRENT_QUEUE_A_MOMENT;
            }
            return ConsumeOrderlyStatus.SUCCESS;
        });
        consumer.start();
    }
}
