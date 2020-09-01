package com.taotao.springbootsendmail.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

/**邮件信息类来保存发送邮件主题，内容
 * @autor tom
 * @date 2020/3/2 0002  22:00
 */
@Data
public class MailVo {
    private  String id;
    private String from;
    private String to;
    private String subject;
    private String text;
    private Date sentDate;
    private String cc;
    private String bcc;
    private String status;
    private String error;
    @JsonIgnore
    private MultipartFile[] multipartFiles;










}
