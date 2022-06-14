/*
package com.example.openfeign.rabbitmq;

import com.example.openfeign.configuration.RabbitMQConfig;
import com.example.openfeign.dao.po.User;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;

*/
/**
 * @author Mr.Cui
 *//*

@Slf4j
@Service
public class RabbitReceiverService {

    @RabbitListener(bindings = @QueueBinding(value = @Queue(value = RabbitMQConfig.TOPIC_QUEUE, durable = "true"), exchange = @Exchange(value = RabbitMQConfig.TOPIC_EXCHANGE, durable = "true", type = ExchangeTypes.TOPIC), key = RabbitMQConfig.TOPIC_ROUTINGKEY))
    @RabbitHandler
    public void receiveTopicMessage(Message message, Channel channel) throws IOException {

        if (log.isDebugEnabled()) {
            log.debug("消费端Payload：" + message.getPayload());
        }

        Long deliveryTag = (Long) message.getHeaders().get(AmqpHeaders.DELIVERY_TAG);
        //手工ack
        channel.basicAck(deliveryTag, false);

    }

    @RabbitListener(bindings = @QueueBinding(value = @Queue(value = RabbitMQConfig.DIRECT_QUEUE, durable = "true"), exchange = @Exchange(value = RabbitMQConfig.DIRECT_EXCHANGE, durable = "true", type = ExchangeTypes.DIRECT), key = RabbitMQConfig.DIRECT_ROUTINGKEY))
    @RabbitHandler
    public void receiveOrderTopicMessage(@Payload User user, Channel channel, @Headers Map headers) throws IOException {

        if (log.isDebugEnabled()) {
            log.debug("消费端Payload：" + user);
        }
        Long deliveryTag = (Long) headers.get(AmqpHeaders.DELIVERY_TAG);
        //手工ack
        channel.basicAck(deliveryTag, false);

    }


}


*/
