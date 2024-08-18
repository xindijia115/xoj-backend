package com.dj.xoj.judge.codesandbox.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.checkerframework.checker.units.qual.A;

import java.util.List;

/**
 * @author: xia
 * @date: 2024-08-17  20:06
 * @description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExecuteCodeRequest {
    /**
     * 输入样例
     */
    private List<String> inputList;

    /**
     * 代码
     */
    private String code;

    /**
     * 语言
     */
    private String language;
}
