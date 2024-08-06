package com.dj.xoj.model.enums;

import org.apache.commons.lang3.ObjectUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 判题信息消息枚举
 *
 * xoj BY DJ
 * 2024/8/3
 */
public enum JudgeInfoMessageEnum {

    ACCEPTED("成功", "accepted"),
    WRONG_ANSWER("答案错误", "wrong answer"),
    COMPILE_ERROR("编译错误", "compile error"),
    MEMORY_LIMIT_EXCEEDED("内存溢出", "memory limit exceeded"),
    TIME_LIMIT_EXCEEDED("时间溢出", "time limit exceeded"),
    PRESENTATION_ERROR("展示错误", "presentation"),
    WAITING("等待中", "waiting"),
    OUTPUT_LIMIT_EXCEEDED("输出溢出", "output limit exceeded"),
    DANGEROUS_OPERATION("危险操作", "dangerous operation"),
    RUNTIME_ERROR("运行错误", "runtime error"),
    SYSTEM_ERROR("系统错误", "system error");


    private final String text;

    private final String value;

    JudgeInfoMessageEnum(String text, String value) {
        this.text = text;
        this.value = value;
    }

    /**
     * 获取值列表
     *
     * @return
     */
    public static List<String> getValues() {
        return Arrays.stream(values()).map(item -> item.value).collect(Collectors.toList());
    }

    /**
     * 根据 value 获取枚举
     *
     * @param value
     * @return
     */
    public static JudgeInfoMessageEnum getEnumByValue(String value) {
        if (ObjectUtils.isEmpty(value)) {
            return null;
        }
        for (JudgeInfoMessageEnum anEnum : JudgeInfoMessageEnum.values()) {
            if (anEnum.value.equals(value)) {
                return anEnum;
            }
        }
        return null;
    }

    public String getValue() {
        return value;
    }

    public String getText() {
        return text;
    }
}
