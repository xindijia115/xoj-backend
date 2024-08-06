package com.dj.xoj.model.dto.questionsubmit;

import com.dj.xoj.common.PageRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 查询请求
 *
 * xoj BY DJ
 * 2024/8/3
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class QuestionSubmitQueryRequest extends PageRequest implements Serializable {

    /**
     * 编程语言
     */
    private String language;

    /**
     * 提交状态
     */
    private Integer status;


    /**
     * 题目id
     */
    private Long questionId;

    /**
     * 用户id
     */
    private Long userId;


    private static final long serialVersionUID = 1L;
}