package com.taotao.springbootsendmail.service;

import com.taotao.springbootsendmail.vo.MailVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.util.StringUtils;

import javax.mail.MessagingException;
import java.util.Date;

/**
 * 邮件业务类
 *
 * @autor tom
 * @date 2020/3/2 0002  21:59
 */
@Service
@Slf4j
public class MailService {
    @Autowired
    private JavaMailSenderImpl mailSender;

    public MailVo sendMail(MailVo mailVo) {
        try {
            checkMail(mailVo);
            sendMimeMail(mailVo);
            return saveMail(mailVo);

        } catch (Exception e) {
            log.error("发送邮件失败 {}", e);
            mailVo.setStatus("fail");
            mailVo.setError(e.getMessage());
            return mailVo;
        }
    }

    private MailVo saveMail(MailVo mailVo) {
        return mailVo;
    }

    public String getMailSendFrom() {
        return mailSender.getJavaMailProperties().getProperty("from");
    }

    private void checkMail(MailVo mailVo) {
        if (Strings.isBlank(mailVo.getTo())) {
            throw new RuntimeException("邮件收件人不能为空");
        }
        if (Strings.isBlank(mailVo.getSubject())) {
            throw new RuntimeException("邮件主题不能为空");
        }
        if (Strings.isBlank(mailVo.getText())) {
            throw new RuntimeException("邮件内容不能为空");
        }
    }

    private void sendMimeMail(MailVo mailVo) {
        try {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mailSender.createMimeMessage(), true);
            mailVo.setFrom(getMailSendFrom());
            messageHelper.setFrom(mailVo.getFrom());
            messageHelper.setTo(mailVo.getTo().split(","));
            messageHelper.setSubject(mailVo.getSubject());
            messageHelper.setText(mailVo.getText());

            if (!StringUtils.isEmpty(mailVo.getCc())) {
                messageHelper.setCc(mailVo.getCc().split(","));
            }
            if (!StringUtils.isEmpty(mailVo.getBcc())) {
                messageHelper.setCc(mailVo.getBcc().split(","));
            }
            if (mailVo.getMultipartFiles() != null) {
                for (MultipartFile multipartFile : mailVo.getMultipartFiles()) {
                    messageHelper.addAttachment(multipartFile.getOriginalFilename(), multipartFile);
                }
            }
            if (StringUtils.isEmpty(String.valueOf(mailVo.getSentDate()))) {
                mailVo.setSentDate(new Date());
                messageHelper.setSentDate(mailVo.getSentDate());
            }

            mailSender.send(messageHelper.getMimeMessage());
            mailVo.setStatus("ok");
            log.info("发送邮件成功：{}->{}", mailVo.getFrom(), mailVo.getTo());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
