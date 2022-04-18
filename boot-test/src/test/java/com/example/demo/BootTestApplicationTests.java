package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@SpringBootTest
class BootTestApplicationTests {

    @Autowired
    JavaMailSenderImpl mailSender;

    @Test
    void contextLoads() {
        //发送一个简单邮件
        SimpleMailMessage mailMessage=new SimpleMailMessage();
        mailMessage.setFrom("1921302384@qq.com"); //发件人
//        mailMessage.setTo("1921302384@qq.com");  //收件人
        mailMessage.setTo("2506678203@qq.com");  //收件人
        mailMessage.setSubject("xxx");           //主题
        mailMessage.setText("sss");              //正文
        mailSender.send(mailMessage);
    }

    @Test
    void contextLoads1() throws MessagingException {
        //发送一个复杂邮件
//        MimeMessage mimeMessage=new MimeMessage(..);
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        //组装
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);

        //主题
        helper.setSubject("theme");
        //正文
        helper.setText("<p style='color:red'>article</p>",true);
        //附件
        helper.addAttachment("I.JPG",new File("C:/Users/K/OneDrive/桌面/work/I.JPG"));
        helper.setFrom("1921302384@qq.com"); //发件人
        helper.setTo("2506678203@qq.com");  //收件人
//        helper.setTo("1921302384@qq.com");   //收件人

        mailSender.send(mimeMessage);
    }


    //自己封装成方法
//    public void sendMail(Boolean multipart, String subject, String text, ) throws MessagingException {
//        //发送一个复杂邮件
////        MimeMessage mimeMessage=new MimeMessage(..);
//        MimeMessage mimeMessage = mailSender.createMimeMessage();
//        //组装
//        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,multipart);
//
//        //主题
//        helper.setSubject(subject);
//        //正文
//        helper.setText(text,true);
//        //附件
//        helper.addAttachment("I.JPG",new File("C:/Users/K/OneDrive/桌面/work/I.JPG"));
//        helper.setFrom("1921302384@qq.com"); //发件人
//        helper.setTo("2506678203@qq.com");  //收件人
////        helper.setTo("1921302384@qq.com");   //收件人
//
//        mailSender.send(mimeMessage);
//    }

}
