package com.dj.xoj.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dj.xoj.model.dto.question.QuestionQueryRequest;
import com.dj.xoj.model.dto.questionsubmit.QuestionSubmitAddRequest;
import com.dj.xoj.model.dto.questionsubmit.QuestionSubmitQueryRequest;
import com.dj.xoj.model.entity.Question;
import com.dj.xoj.model.entity.QuestionSubmit;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dj.xoj.model.entity.User;
import com.dj.xoj.model.vo.QuestionSubmitVO;
import com.dj.xoj.model.vo.QuestionVO;

import javax.servlet.http.HttpServletRequest;

/**
* @author 86178
* @description 针对表【question_submit(题目提交表)】的数据库操作Service
* @createDate 2024-08-05 13:22:35
*/
public interface QuestionSubmitService extends IService<QuestionSubmit> {

    /**
     * 题目提交
     *
     * @param questionSubmitAddRequest
     * @param loginUser
     * @return 提交id
     */
    long doQuestionSubmit(QuestionSubmitAddRequest questionSubmitAddRequest, User loginUser);


    QueryWrapper<QuestionSubmit> getQueryWrapper(QuestionSubmitQueryRequest questionSubmitQueryRequest);


    /**
     * 获取题目封装
     *
     * @param questionSubmit
     * @param loginUser
     * @return
     */
    QuestionSubmitVO getQuestionSubmitVO(QuestionSubmit questionSubmit, User loginUser);

    /**
     * 分页获取题目封装
     *
     * @param questionSubmitPage
     * @param loginUser
     * @return
     */
    Page<QuestionSubmitVO> getQuestionSubmitVOPage(Page<QuestionSubmit> questionSubmitPage, User loginUser);

}
