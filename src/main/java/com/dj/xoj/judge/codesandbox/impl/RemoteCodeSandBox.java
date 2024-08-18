package com.dj.xoj.judge.codesandbox.impl;

import com.dj.xoj.judge.codesandbox.CodeSandBox;
import com.dj.xoj.judge.codesandbox.model.ExecuteCodeRequest;
import com.dj.xoj.judge.codesandbox.model.ExecuteCodeResponse;

/**
 * @author: xia
 * @date: 2024-08-17  20:11
 * @description: 真正调用的代码沙箱接口
 */
public class RemoteCodeSandBox implements CodeSandBox {
    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        System.out.println("这个是远程沙箱，真正调用沙箱的地方");
        return null;
    }
}
