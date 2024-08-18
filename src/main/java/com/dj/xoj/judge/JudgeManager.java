package com.dj.xoj.judge;

import com.dj.xoj.judge.strategy.DefaultJudgeStrategy;
import com.dj.xoj.judge.strategy.JavaDefaultJudgeStrategy;
import com.dj.xoj.judge.strategy.JudgeContext;
import com.dj.xoj.judge.strategy.JudgeStrategy;
import com.dj.xoj.judge.codesandbox.model.JudgeInfo;
import org.springframework.stereotype.Component;

/**
 * @author: xia
 * @date: 2024-08-18  13:09
 * @description: 判题策略管理，用来管理到底是用哪一种策略来进行判题(默认，java)
 */
@Component
public class JudgeManager {

    /**
     * 执行判题
     * @param judgeContext
     * @return
     */
    JudgeInfo doJudge(JudgeContext judgeContext){
        JudgeStrategy judgeStrategy = new DefaultJudgeStrategy();
        if ("java".equals(judgeContext.getQuestionSubmit().getLanguage())) {
            judgeStrategy = new JavaDefaultJudgeStrategy();
        }
        return judgeStrategy.doJudge(judgeContext);
    }
}
