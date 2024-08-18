package com.dj.xoj.judge.codesandbox.impl;

import com.dj.xoj.judge.codesandbox.CodeSandBox;
import com.dj.xoj.judge.codesandbox.model.ExecuteCodeRequest;
import com.dj.xoj.judge.codesandbox.model.ExecuteCodeResponse;
import com.dj.xoj.judge.codesandbox.model.JudgeInfo;
import com.dj.xoj.model.enums.JudgeInfoMessageEnum;
import com.dj.xoj.model.enums.QuestionSubmitStatusEnum;

import java.util.List;

/**
 * @author: xia
 * @date: 2024-08-17  20:09
 * @description: 样例代码沙箱
 */
public class ExampleCodeSandBox implements CodeSandBox {
    /**
     * 写死的样例，测试用
     *
     * @param executeCodeRequest
     * @return
     */
    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        ExecuteCodeResponse executeCodeResponse = new ExecuteCodeResponse();
        List<String> inputList = executeCodeRequest.getInputList();
        executeCodeResponse.setOutputList(inputList);
        executeCodeResponse.setMessage(JudgeInfoMessageEnum.ACCEPTED.getValue());
        executeCodeResponse.setStatus(QuestionSubmitStatusEnum.SUCCEED.getValue());
        JudgeInfo judgeInfo = new JudgeInfo();
        judgeInfo.setMessage(JudgeInfoMessageEnum.ACCEPTED.getValue());
        judgeInfo.setMemory(1000L);
        judgeInfo.setTime(1000L);
        executeCodeResponse.setJudgeInfo(judgeInfo);
        return executeCodeResponse;
    }
}
