package com.example.demo.service;

public interface MailService {


    void sendSipleMail(String to, String subject, String content);

    /**
     * 发送html
     * @param to 邮件接收人
     * @param subject 邮件主题
     * @param content 邮件内容
     */
    void sendHtmlMail(String to, String subject, String content);
}
