package com.nowcoder.community.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Component
public class MailClent {
    public static final Logger logger = LoggerFactory.getLogger(MailClent.class);

    @Autowired
    private JavaMailSender mailSender;

    //@Value("${spring.mail.username}")通过这个key 将邮箱发件人注入到from属性中
    @Value("${spring.mail.username}")
    private String from;

    public void sendMail(String to, String subject, String content) {
        try {
            ////JavaMailSender组件结构很简单，MimeMessage为邮件的主题，send方法即为发送
            MimeMessage message = mailSender.createMimeMessage();
            //spring提供一个帮助类MimeMessageHelper，可以帮助我们构建MimeMessage中的内容
            MimeMessageHelper helper = new MimeMessageHelper(message);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content, true);
            mailSender.send(helper.getMimeMessage());
        } catch (MessagingException e) {
            //try-catch记录日志，为以后排错提供依据
            logger.error("发送邮件失败:" + e.getMessage());
        }
    }
}
