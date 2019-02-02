package com.example.demo.service.impl;

import com.example.demo.service.MailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;


@Service
public class MailServiceImpl implements MailService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

//    @Autowired
//    private JavaMailSender mailSender;

//    @Value("${mail.fromMail.addr}")
//    private String from;

    @Override
    public void sendSipleMail(String to, String subject, String content) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(content);

        try {
//            mailSender.send(message);
            logger.info("简单邮件已经发送。");
        } catch (Exception e) {
            logger.error("发送简单邮件时发生异常！", e);
        }

    }


    @Override
    public void sendHtmlMail(String to, String subject, String content) {

//        MimeMessage mimeMessage = mailSender.createMimeMessage();

//        try {
//            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
//            helper.setFrom(from);
//            helper.setTo(to);
//            helper.setSubject(subject);
//            helper.setText(content);
//            mailSender.send(mimeMessage);
//            logger.info("html邮件发送成功");
//        } catch (MessagingException e) {
//            e.printStackTrace();
//            logger.error("发送html邮件时发生异常！", e);
//        }
    }
}
