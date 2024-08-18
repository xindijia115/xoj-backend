package com.dj.xoj.judge.strategy;

import com.dj.xoj.model.dto.question.JudgeCase;
import com.dj.xoj.judge.codesandbox.model.JudgeInfo;
import com.dj.xoj.model.entity.Question;
import com.dj.xoj.model.entity.QuestionSubmit;
import lombok.Data;

import java.util.List;

/**
 * @author: xia
 * @date: 2024-08-18  12:35
 * @description:
 */
@Data
public class JudgeContext {

    private JudgeInfo judgeInfo;

    private List<String> inputList;

    private List<String> outputList;

    private Question question;

    private List<JudgeCase> judgeCaseList;

    private QuestionSubmit questionSubmit;
}
