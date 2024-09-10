package com.tp.quizAppMicroservices.Service.serviceImpl;

import com.tp.quizAppMicroservices.Entity.ApiResponse;
import com.tp.quizAppMicroservices.Entity.Question;
import com.tp.quizAppMicroservices.Service.QuestionService;
import com.tp.quizAppMicroservices.dao.QuestionDao;
import com.tp.quizAppMicroservices.util.ResponseUtil;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Data
public class QuestionServiceImpl implements QuestionService {

    private final QuestionDao questionDao;

    @Override
    public ResponseEntity<ApiResponse> createQuestion(Question question) {
        Question savedquestion =  questionDao.createQuestion(question);
        return ResponseUtil.getOkResponse(savedquestion);
    }

    @Override
    public ResponseEntity<ApiResponse> getAllQuestions() {
        List<Question> questionsList = questionDao.getAllQuestions();
        return ResponseUtil.getOkResponse(questionsList);
    }

    @Override
    public ResponseEntity<ApiResponse> getQuestionsBycategory(String category) {
        List<Question> questionsList = questionDao.getQuestionsByCategory(category);
        return ResponseUtil.getOkResponse(questionsList);
    }
}
