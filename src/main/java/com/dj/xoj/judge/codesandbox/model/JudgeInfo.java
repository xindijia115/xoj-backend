package com.dj.xoj.judge.codesandbox.model;

import lombok.Data;

/**
 * @author: xia
 * @date: 2024-08-05  14:22
 * @description: 判题信息
 */
@Data
public class JudgeInfo {
    /**
     * 程序执行信息
     */
    private String message;

    /**
     * 消耗内存(kb)
     */
    private Long memory;

    /**
     * 消耗时间(ms)
     */
    private Long time;
}
