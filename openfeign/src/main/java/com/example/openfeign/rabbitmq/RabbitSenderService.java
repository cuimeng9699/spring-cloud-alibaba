/*
package com.example.openfeign.rabbitmq;

import com.example.openfeign.dao.po.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;

*/
/**
 * @ClassName RabbitSenderServiceImpl
 * @Description TODO
 * @Author Mr.Cui
 * @Date 6/8/22 7:18 PM
 *//*

@Service
@Slf4j
public class RabbitSenderService{

    @Autowired

    private RabbitTemplate rabbitTemplate;

    final RabbitTemplate.ConfirmCallback CONFIRM_CALLBACK = (correlationData, ack, cause) -> {

        if (log.isDebugEnabled()) {

            log.debug("correlationData：" + correlationData + " ack：" + ack);

        }

        if (!ack) {

            if (log.isErrorEnabled()) {

                log.error("异常处理");

            }

        }

    };

    final RabbitTemplate.ReturnCallback RETURN_CALLBACK = (message, replyCode, replyText, exchange, routingKey) -> {

        if (log.isErrorEnabled()) {

            log.error("replyCode：" + replyCode + " replyText：" + replyText + " exchange：" + exchange + " routingKey：" + routingKey);

        }

    };


    public void send(String exchange, String routingKey, Object message, Map properties) {

        MessageHeaders messageHeaders = new MessageHeaders(properties);

        Message msg = MessageBuilder.createMessage(message, messageHeaders);

        rabbitTemplate.setConfirmCallback(CONFIRM_CALLBACK);

        rabbitTemplate.setReturnCallback(RETURN_CALLBACK);

        CorrelationData correlationData = new CorrelationData();

        correlationData.setId(UUID.randomUUID().toString() + "-" + System.currentTimeMillis());

        rabbitTemplate.convertAndSend(exchange, routingKey, msg, correlationData);

    }
    

    public void sendOrder(String exchange, String routingKey, User user) {

        rabbitTemplate.setConfirmCallback(CONFIRM_CALLBACK);

        rabbitTemplate.setReturnCallback(RETURN_CALLBACK);

        CorrelationData correlationData = new CorrelationData();

        correlationData.setId(UUID.randomUUID().toString() + "-" + System.currentTimeMillis());

        rabbitTemplate.convertAndSend(exchange, routingKey,user, correlationData);

    }
    

}
*/
