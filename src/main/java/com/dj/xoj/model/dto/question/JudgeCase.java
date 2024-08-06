package com.dj.xoj.model.dto.question;

import lombok.Data;

/**
 * @author: xia
 * @date: 2024-08-05  14:11
 * @description: 题目用例
 */
@Data
public class JudgeCase {

    /**
     * 输入
     */
    private String input;

    /**
     * 输出
     */
    private String output;
}
