package com.dj.xoj.judge;

import com.dj.xoj.model.entity.QuestionSubmit;
import com.dj.xoj.model.vo.QuestionSubmitVO;

/**
 * @author: xia
 * @date: 2024-08-17  21:12
 * @description:判题服务
 */
public interface JudgeService {

    QuestionSubmit doJudge(long questionSubmitId);
}
