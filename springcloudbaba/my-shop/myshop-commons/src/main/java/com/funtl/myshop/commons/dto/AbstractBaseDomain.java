package com.funtl.myshop.commons.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 通用领域模型
 * @author tom
 * @date 2020/3/26 0026 18:14
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class AbstractBaseDomain implements Serializable{
    private  Long  id;

    /**
     * 格式化日期，由于是北京时间（我们是在东八区），所以时区 +8
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date created;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updated;
}
