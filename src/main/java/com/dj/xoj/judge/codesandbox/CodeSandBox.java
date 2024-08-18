package com.dj.xoj.judge.codesandbox;

import com.dj.xoj.judge.codesandbox.model.ExecuteCodeRequest;
import com.dj.xoj.judge.codesandbox.model.ExecuteCodeResponse;

/**
 * @author: xia
 * @date: 2024-08-17  20:04
 * @description: 代码沙箱接口
 */
public interface CodeSandBox {

    /**
     * 执行代码
     * @param executeCodeRequest
     * @return
     */
    ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest);
}
