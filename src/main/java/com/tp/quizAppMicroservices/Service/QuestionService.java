package com.tp.quizAppMicroservices.Service;

import com.tp.quizAppMicroservices.Entity.ApiResponse;
import com.tp.quizAppMicroservices.Entity.Question;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


public interface QuestionService {

    public ResponseEntity<ApiResponse> createQuestion(Question question);

    ResponseEntity<ApiResponse> getAllQuestions();

    ResponseEntity<ApiResponse> getQuestionsBycategory(String category);
}
