package com.tp.quizAppMicroservices.Controller.questionController;

import com.tp.quizAppMicroservices.Entity.ApiResponse;
import com.tp.quizAppMicroservices.Entity.Question;
import com.tp.quizAppMicroservices.Service.QuestionService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Data
@RequestMapping("question")
@RestController
@RequiredArgsConstructor
public class QuestionController {


   private final QuestionService questionService;

    @PostMapping("/create")
    public ResponseEntity<ApiResponse> createQuestion(@RequestBody Question question){
        return questionService.createQuestion(question);
    }

    @GetMapping("/allQuestions")
    public ResponseEntity<ApiResponse> getAllQuestions()
    {
        return questionService.getAllQuestions();
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<ApiResponse> getQuestionsByCategory(@PathVariable String category){
        return questionService.getQuestionsBycategory(category);
    }

}
