package com.example.demo.controller;

import com.example.demo.entity.MailDataEntity;
import com.example.demo.entity.MailEntity;
import com.example.demo.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@RestController
@RequestMapping("/mail")
public class MailController {

    @Autowired
    private MailService mailService;

    @Autowired
    private TemplateEngine templateEngine;

    @GetMapping("/send")
    public MailEntity sendMail(MailDataEntity params) {

        mailService.sendSipleMail(params.getTo(), params.getSubject(), params.getContent());

        return getMailEntity(params);
    }

    private MailEntity getMailEntity(MailDataEntity params) {
        MailEntity entity = new MailEntity();
        entity.setCode(200);
        entity.setMessage("发送成功");

        MailDataEntity dataEntity = new MailDataEntity();
        dataEntity.setTo(params.getTo());
        dataEntity.setContent(params.getSubject());
        dataEntity.setSubject(params.getContent());

        entity.setData(dataEntity);
        return entity;
    }

    @GetMapping("/send/html")
    public MailEntity sendMailHtml(MailDataEntity params) {
        mailService.sendHtmlMail(params.getTo(), params.getSubject(), params.getContent());

        return getMailEntity(params);
    }

    @GetMapping("/send/template")
    public MailEntity sendMailTemplate(MailDataEntity params) {

        Context context = new Context();
        context.setVariable("id", "006") ;
        String emailTemplate = templateEngine.process("mail/emailTemplate", context);

        mailService.sendHtmlMail(params.getTo(), params.getSubject(), emailTemplate);

        return getMailEntity(params);
    }
}
