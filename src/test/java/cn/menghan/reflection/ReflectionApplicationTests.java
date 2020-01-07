package cn.menghan.reflection;

import cn.menghan.reflection.service.DemoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ReflectionApplicationTests {

    @Autowired
    DemoService demoService;

    @Test
    void contextLoads() {
    }

    @Test
    void DemoTest() {
        String single = demoService.saveDemo("person");
        System.out.println(single);
    }

}
