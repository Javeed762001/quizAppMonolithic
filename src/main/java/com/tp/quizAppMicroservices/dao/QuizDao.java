package com.tp.quizAppMicroservices.dao;

import com.tp.quizAppMicroservices.Entity.Question;
import com.tp.quizAppMicroservices.Entity.Quiz;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface QuizDao {

    List<Question> getRandomQuestionsByCategory(String category, int noOfQuestions);

    Quiz createQuiz(Quiz quiz);

    Quiz getQuizById(String quizId);
}
