package com.example.openfeign;

import com.example.openfeign.dao.mapper.extend.UserExtMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class OpenfeignApplicationTests {
    @Resource
    private UserExtMapper userExtMapper;

    @Test
    void contextLoads() {
        /*String sql = "SELECT (CASE WHEN user_name = '张三' then '111'\n" +
                "ELSE '222' end)as NAME, (city_id+area_id)as num\n" +
                " FROM user_extend";*/
        //String sql = "delete from user_extend where id = 17";
        //List<Map> sql1 = userExtMapper.getSql(sql);

    Map map = new HashMap();
    map.put("tableName","user");
        userExtMapper.delete(map);
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
