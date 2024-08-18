package com.dj.xoj.judge.strategy;

import com.dj.xoj.judge.codesandbox.model.JudgeInfo;

/**
 * @author: xia
 * @date: 2024-08-18  12:34
 * @description:判题策略
 */
public interface JudgeStrategy {

    /**
     * 执行判题
     * @param judgeContext
     * @return
     */
    JudgeInfo doJudge(JudgeContext judgeContext);
}
