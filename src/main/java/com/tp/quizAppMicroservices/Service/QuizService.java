package com.tp.quizAppMicroservices.Service;

import com.tp.quizAppMicroservices.Entity.ApiResponse;
import com.tp.quizAppMicroservices.dto.ResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


public interface QuizService {
    ResponseEntity<ApiResponse> createQuiz(String category, int noOfQuestions, String title);

    ResponseEntity<ApiResponse> getQuizQuestions(String quizId);

    ResponseEntity<ApiResponse> calculateResult(String id, List<ResponseDto> responses);
}
