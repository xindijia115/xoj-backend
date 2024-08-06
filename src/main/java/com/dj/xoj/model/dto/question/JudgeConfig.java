package com.dj.xoj.model.dto.question;

import lombok.Data;

/**
 * @author: xia
 * @date: 2024-08-05  14:12
 * @description: 题目配置
 */
@Data
public class JudgeConfig {
    /**
     * 时间限制(ms)
     */
    private long timeLimit;

    /**
     * 内存限制(KB)
     */
    private long memoryLimit;

    /**
     * 堆栈限制(KB)
     */
    private long stackLimit;

}
