package com.dj.xoj.model.dto.question;
import lombok.Data;
import java.io.Serializable;
import java.util.List;

/**
 * 创建请求
 * <p>
 * xoj BY DJ
 * 2024/8/3
 */
@Data
public class QuestionAddRequest implements Serializable {

    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;

    /**
     * 标签列表（json 数组）
     */
    private List<String> tags;

    /**
     * 题目答案
     */
    private String answer;

    /**
     * 判题用例(JSON数组)
     */
    private List<JudgeCase> judgeCase;

    /**
     * 判题配置(JSON对象)
     */
    private JudgeConfig judgeConfig;
    private static final long serialVersionUID = 1L;
}