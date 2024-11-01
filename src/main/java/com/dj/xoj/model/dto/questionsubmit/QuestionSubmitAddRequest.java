package com.dj.xoj.model.dto.questionsubmit;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * xoj BY DJ
 * 2024/8/3
 */
@Data
public class QuestionSubmitAddRequest implements Serializable {

    /**
     * 编程语言
     */
    private String language;

    /**
     * 用户代码
     */
    private String code;


    /**
     * 题目id
     */
    private Long questionId;


    private static final long serialVersionUID = 1L;
}