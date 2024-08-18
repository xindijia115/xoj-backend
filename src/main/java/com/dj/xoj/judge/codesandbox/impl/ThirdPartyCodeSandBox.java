package com.dj.xoj.judge.codesandbox.impl;

import com.dj.xoj.judge.codesandbox.CodeSandBox;
import com.dj.xoj.judge.codesandbox.model.ExecuteCodeRequest;
import com.dj.xoj.judge.codesandbox.model.ExecuteCodeResponse;

/**
 * @author: xia
 * @date: 2024-08-17  20:16
 * @description: 第三方代码沙箱接口
 */
public class ThirdPartyCodeSandBox implements CodeSandBox {
    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        System.out.println("这个是调用第三方代码沙箱接口");
        return null;
    }
}
