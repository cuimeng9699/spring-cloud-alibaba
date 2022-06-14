package com.example.openfeign;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OpenfeignApplicationTests {

    @Test
    void contextLoads() {
    }

    /*@Autowired

    private RabbitSenderService rabbitSenderService;

    @Test

    public void testSender1() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

        Map properties = new HashMap<>();

        properties.put("number", "12345");

        properties.put("send_time", sdf.format(new Date()));

        rabbitSenderService.send(RabbitMQConfig.TOPIC_EXCHANGE, "topic.user", "Hello World", properties);

    }

    @Test

    public void testSender2() {
        User user = new User();
        user.setId(1);
        user.setName("张三");

        rabbitSenderService.sendOrder(RabbitMQConfig.DIRECT_EXCHANGE, RabbitMQConfig.DIRECT_ROUTINGKEY, user);

    }*/

}
