package com.tp.quizAppMicroservices.dao;

import com.tp.quizAppMicroservices.Entity.Question;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface QuestionDao {

    public Question createQuestion(Question question);

    List<Question> getAllQuestions();

    List<Question> getQuestionsByCategory(String category);
}
