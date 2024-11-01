package com.dj.xoj.judge.codesandbox;

import com.dj.xoj.common.ErrorCode;
import com.dj.xoj.exception.BusinessException;
import com.dj.xoj.judge.codesandbox.impl.ExampleCodeSandBox;
import com.dj.xoj.judge.codesandbox.impl.RemoteCodeSandBox;
import com.dj.xoj.judge.codesandbox.impl.ThirdPartyCodeSandBox;


/**
 * @author: xia
 * @date: 2024-08-17  20:34
 * @description:代码沙箱工厂,根据开发者设置的字符串参数来决定使用哪一种代码沙箱
 */
public class CodeSandBoxFactory {

    public static CodeSandBox newInstance(String type) throws BusinessException {
        switch (type) {
            case "example":
                return new ExampleCodeSandBox();
            case "remote":
                return new RemoteCodeSandBox();
            case "thirdParty":
                return new ThirdPartyCodeSandBox();
            default:
                throw new BusinessException(ErrorCode.PARAMS_ERROR, "代码沙箱不存在");
        }
    }
}
