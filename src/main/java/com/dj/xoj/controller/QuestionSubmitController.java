package com.dj.xoj.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dj.xoj.annotation.AuthCheck;
import com.dj.xoj.common.BaseResponse;
import com.dj.xoj.common.ErrorCode;
import com.dj.xoj.common.ResultUtils;
import com.dj.xoj.constant.UserConstant;
import com.dj.xoj.exception.BusinessException;
import com.dj.xoj.model.dto.question.QuestionQueryRequest;
import com.dj.xoj.model.dto.questionsubmit.QuestionSubmitAddRequest;
import com.dj.xoj.model.dto.questionsubmit.QuestionSubmitQueryRequest;
import com.dj.xoj.model.entity.Question;
import com.dj.xoj.model.entity.QuestionSubmit;
import com.dj.xoj.model.entity.User;
import com.dj.xoj.model.vo.QuestionSubmitVO;
import com.dj.xoj.service.QuestionSubmitService;
import com.dj.xoj.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 帖子点赞接口
 *
 * xoj BY DJ
 * 2024/8/3
 */
@RestController
@RequestMapping("/question_submit")
@Slf4j
public class QuestionSubmitController {

    @Resource
    private QuestionSubmitService questionSubmitService;

    @Resource
    private UserService userService;

    /**
     * 点赞 / 取消点赞
     *
     * @param questionSubmitAddRequest
     * @param request
     * @return resultNum 本次点赞变化数
     */
    @PostMapping("/")
    public BaseResponse<Long> doQuestionSubmit(@RequestBody QuestionSubmitAddRequest questionSubmitAddRequest,
            HttpServletRequest request) {
        if (questionSubmitAddRequest == null || questionSubmitAddRequest.getQuestionId() <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        // 登录才能点赞
        final User loginUser = userService.getLoginUser(request);
        long questionSubmitId = questionSubmitService.doQuestionSubmit(questionSubmitAddRequest, loginUser);
        return ResultUtils.success(questionSubmitId);
    }

    /**
     * 分页获取题目提交列表（管理员和用户本人）
     *
     * @param questionSubmitQueryRequest
     * @return
     */
    @PostMapping("/list/page")
    public BaseResponse<Page<QuestionSubmitVO>> listQuestionSubmitByPage(@RequestBody QuestionSubmitQueryRequest questionSubmitQueryRequest, HttpServletRequest request) {
        long current = questionSubmitQueryRequest.getCurrent();
        long size = questionSubmitQueryRequest.getPageSize();
        // 原始题目信息
        Page<QuestionSubmit> questionSubmitPage = questionSubmitService.page(new Page<>(current, size),
                questionSubmitService.getQueryWrapper(questionSubmitQueryRequest));
        // 脱敏
        User loginUser = userService.getLoginUser(request);
        return ResultUtils.success(questionSubmitService.getQuestionSubmitVOPage(questionSubmitPage, loginUser));
    }


}
