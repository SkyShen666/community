package com.nowcoder.community;

import com.nowcoder.community.util.MailClent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;


@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class MailTests {

    @Autowired
    private MailClent mailClent;

    @Autowired
    private TemplateEngine templateEngine;

    @Test
    public void testTextMail() {
        mailClent.sendMail("543190701@qq.com", "Test", "Hello.");
    }

    @Test
    public void testHtmlMail() {
        Context context = new Context();
        context.setVariable("username", "Shen");

        String content = templateEngine.process("/mail/demo", context);
        System.out.println(content);

        mailClent.sendMail("543190701@qq.com", "HTML", content);
    }

}
