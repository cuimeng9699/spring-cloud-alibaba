/*
package com.example.openfeign.configuration;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

*/
/**
 * @ClassName RabbitMQConfig
 * @Description TODO
 * @Author Mr.Cui
 * @Date 6/8/22 7:40 PM
 *//*

@Configuration
public class RabbitMQConfig {
    */
/**
     * EXCHANGE名称
     *//*


    public static final String FANOUT_EXCHANGE = "test.fanout";

    public static final String DIRECT_EXCHANGE = "test.direct";

    public static final String TOPIC_EXCHANGE = "test.topic";

    */
/**
     * QUEUE名称
     *//*


    public static final String FANOUT_QUEUE = "test.fanout.queue";

    public static final String DIRECT_QUEUE = "test.direct.queue";

    public static final String TOPIC_QUEUE = "test.topic.queue";

    */
/**
     * ROUTINGKEY名称
     *//*


    public static final String DIRECT_ROUTINGKEY = "direct";

    public static final String TOPIC_ROUTINGKEY = "topic.#";

    @Bean

    public ConnectionFactory connectionFactory(Environment environment) {

        String addresses = environment.getProperty("spring.rabbitmq.addresses");

        int port = environment.getProperty("spring.rabbitmq.port", Integer.class);

        String username = environment.getProperty("spring.rabbitmq.username");

        String password = environment.getProperty("spring.rabbitmq.password");

        String virtualHost = environment.getProperty("spring.rabbitmq.virtual-host");

        CachingConnectionFactory connectionFactory = new CachingConnectionFactory(addresses, port);

        connectionFactory.setUsername(username);

        connectionFactory.setPassword(password);

        connectionFactory.setVirtualHost(virtualHost);

        connectionFactory.setPublisherConfirms(true);

        return connectionFactory;

    }

    @Bean

    public FanoutExchange fanoutExchange() {

        return new FanoutExchange(FANOUT_EXCHANGE, true, false);

    }

    @Bean

    public DirectExchange directExchange() {

        return new DirectExchange(DIRECT_EXCHANGE, true, false);

    }

    @Bean

    public TopicExchange topicExchange() {

        return new TopicExchange(TOPIC_EXCHANGE, true, false);

    }

    @Bean

    public Queue fanoutQueue() {

        return new Queue(FANOUT_QUEUE, true);

    }

    @Bean

    public Queue directQueue() {

        return new Queue(DIRECT_QUEUE, true);

    }

    @Bean

    public Queue topicQueue() {

        return new Queue(TOPIC_QUEUE, true);

    }

    @Bean

    public Binding fanoutBinding() {

        return BindingBuilder.bind(fanoutQueue()).to(fanoutExchange());

    }

    @Bean

    public Binding directBinding() {

        return BindingBuilder.bind(directQueue()).to(directExchange()).with(DIRECT_ROUTINGKEY);

    }

    @Bean

    public Binding topicBinding() {

        return BindingBuilder.bind(topicQueue()).to(topicExchange()).with(TOPIC_ROUTINGKEY);

    }

}

*/
