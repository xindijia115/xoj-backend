package com.dj.xoj.judge.codesandbox;

import com.dj.xoj.judge.codesandbox.model.ExecuteCodeRequest;
import com.dj.xoj.judge.codesandbox.model.ExecuteCodeResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author: xia
 * @date: 2024-08-17  20:46
 * @description: 代码沙箱代理，用于增加一些额外的功能, 可以理解为中间商
 */

@Slf4j
@AllArgsConstructor
public class CodeSandBoxProxy implements CodeSandBox{

    private final CodeSandBox codeSandBox;


    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        //在执行前...
        log.info("准备执行...");
        ExecuteCodeResponse executeCodeResponse = codeSandBox.executeCode(executeCodeRequest);
        //打印响应信息
        log.info(executeCodeResponse.toString());
        return executeCodeResponse;
    }
}
