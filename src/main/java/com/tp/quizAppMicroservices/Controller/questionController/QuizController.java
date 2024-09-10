package com.tp.quizAppMicroservices.Controller.questionController;

import com.tp.quizAppMicroservices.Entity.ApiResponse;
import com.tp.quizAppMicroservices.Entity.Question;
import com.tp.quizAppMicroservices.Service.QuizService;
import com.tp.quizAppMicroservices.dto.ResponseDto;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Data
@RequiredArgsConstructor
@RequestMapping("quiz")
public class QuizController {

    private final QuizService quizService;

    @PostMapping("/create")
    public ResponseEntity<ApiResponse> createQuiz(@RequestParam String category, @RequestParam int noOfQuestions, @RequestParam String title ){
        return quizService.createQuiz(category,noOfQuestions,title);
    }

    @GetMapping("/get/{quizId}")
    public ResponseEntity<ApiResponse> getQuizQuestions(@PathVariable String quizId){
        return quizService.getQuizQuestions(quizId);
    }

    @PostMapping("submit/{id}")
    public ResponseEntity<ApiResponse> submitQuiz(@PathVariable String id, @RequestBody List<ResponseDto> responses){
        return quizService.calculateResult(id , responses);
    }

}
