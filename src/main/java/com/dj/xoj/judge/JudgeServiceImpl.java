package com.dj.xoj.judge;

import cn.hutool.json.JSONUtil;
import com.dj.xoj.common.ErrorCode;
import com.dj.xoj.exception.BusinessException;
import com.dj.xoj.judge.codesandbox.CodeSandBox;
import com.dj.xoj.judge.codesandbox.CodeSandBoxFactory;
import com.dj.xoj.judge.codesandbox.CodeSandBoxProxy;
import com.dj.xoj.judge.codesandbox.model.ExecuteCodeRequest;
import com.dj.xoj.judge.codesandbox.model.ExecuteCodeResponse;
import com.dj.xoj.judge.strategy.JudgeContext;
import com.dj.xoj.model.dto.question.JudgeCase;
import com.dj.xoj.judge.codesandbox.model.JudgeInfo;
import com.dj.xoj.model.entity.Question;
import com.dj.xoj.model.entity.QuestionSubmit;
import com.dj.xoj.model.enums.QuestionSubmitStatusEnum;
import com.dj.xoj.service.QuestionService;
import com.dj.xoj.service.QuestionSubmitService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: xia
 * @date: 2024-08-17  21:14
 * @description:
 */
@Service
public class JudgeServiceImpl implements JudgeService {

    @Resource
    private QuestionService questionService;

    @Resource
    private QuestionSubmitService questionSubmitService;

    @Value("${codesandbox.type}")
    private String type;

    @Resource
    private JudgeManager judgeManager;

    @Override
    public QuestionSubmit doJudge(long questionSubmitId) {
        // 查询题目提交信息
        QuestionSubmit questionSubmit = questionSubmitService.lambdaQuery().eq(QuestionSubmit::getId, questionSubmitId).one();
        if (questionSubmit == null) {
            throw new BusinessException(ErrorCode.NOT_FOUND_ERROR, "提交信息不存在");
        }
        // 查询题目信息
        Long questionId = questionSubmit.getQuestionId();
        Question question = questionService.getById(questionId);
        if (question == null) {
            throw new BusinessException(ErrorCode.NOT_FOUND_ERROR, "题目信息不存在");
        }
        // 判断是否位等待状态
        Integer status = questionSubmit.getStatus();
        if (!status.equals(QuestionSubmitStatusEnum.WAITING.getValue())) {
            throw new BusinessException(ErrorCode.OPERATION_ERROR, "题目正在判题中");
        }
        // 更新提交题目状态
        QuestionSubmit updateQuestionSubmit = new QuestionSubmit();
        updateQuestionSubmit.setId(questionSubmitId);
        updateQuestionSubmit.setStatus(QuestionSubmitStatusEnum.RUNNING.getValue());
        boolean result = questionSubmitService.updateById(updateQuestionSubmit);
        if (!result) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "题目状态更新失败");
        }
        // 调用代码沙箱 获取执行结果
        CodeSandBox codeSandBox = CodeSandBoxFactory.newInstance(type);
        codeSandBox = new CodeSandBoxProxy(codeSandBox);
        String judgeCaseStr = question.getJudgeCase();
        List<JudgeCase> judgeCasesList = JSONUtil.toList(judgeCaseStr, JudgeCase.class);
        String language = questionSubmit.getLanguage();
        String code = questionSubmit.getCode();
        List<String> inputList = judgeCasesList.stream().map(JudgeCase::getInput).collect(Collectors.toList());
        ExecuteCodeRequest executeCodeRequest = ExecuteCodeRequest.builder()
                .code(code)
                .language(language)
                .inputList(inputList)
                .build();
        ExecuteCodeResponse executeCodeResponse = codeSandBox.executeCode(executeCodeRequest);
        // 获取输出结果
        List<String> outputList = executeCodeResponse.getOutputList();
        // 修改判题状态和信息
        JudgeContext judgeContext = new JudgeContext();
        judgeContext.setJudgeInfo(executeCodeResponse.getJudgeInfo());
        judgeContext.setInputList(inputList);
        judgeContext.setOutputList(outputList);
        judgeContext.setQuestion(question);
        judgeContext.setJudgeCaseList(judgeCasesList);
        judgeContext.setQuestionSubmit(questionSubmit);
        //执行判题
        JudgeInfo judgeInfo = judgeManager.doJudge(judgeContext);
        //修改数据库中的判题结果
        updateQuestionSubmit = new QuestionSubmit();
        updateQuestionSubmit.setId(questionSubmitId);
        updateQuestionSubmit.setStatus(QuestionSubmitStatusEnum.SUCCEED.getValue());
        updateQuestionSubmit.setJudgeInfo(JSONUtil.toJsonStr(judgeInfo));
        result = questionSubmitService.updateById(updateQuestionSubmit);
        if (!result) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "题目状态更新失败");
        }
        QuestionSubmit questionSubmitResult = questionSubmitService.getById(questionSubmitId);
        return questionSubmitResult;
    }
}
