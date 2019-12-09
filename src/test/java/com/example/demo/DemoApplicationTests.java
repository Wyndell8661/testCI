package com.example.demo;

import com.example.demo.services.SensitivePersonService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    private SensitivePersonService sensitivePersonService;
    @Test
    public void contextLoads() {
    }

    @Test
    public void test1() {
    String id = "015222ba9ff1404cab4de5eaa33882ae";
        System.out.println(sensitivePersonService.getPersonInfo(id));
    }

    @Test
    public void testStrength(){
        String password = "wujunyi";
        //匹配中文或空格；
        Pattern p1 = Pattern.compile("[\u4e00-\u9fa5]|\\s");
        Matcher matcher = p1.matcher(password);
        Assert.assertTrue(matcher.find());
        //
    }

}
