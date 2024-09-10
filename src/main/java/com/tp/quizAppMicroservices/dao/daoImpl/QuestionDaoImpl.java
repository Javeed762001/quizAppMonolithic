package com.tp.quizAppMicroservices.dao.daoImpl;

import com.tp.quizAppMicroservices.Entity.Question;
import com.tp.quizAppMicroservices.dao.QuestionDao;
import com.tp.quizAppMicroservices.repository.QuestionRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Data
public class QuestionDaoImpl implements QuestionDao {

    private final QuestionRepository questionRepository;

    @Override
    public Question createQuestion(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    @Override
    public List<Question> getQuestionsByCategory(String category) {
        return questionRepository.findQuestionsByCategory(category);
    }
}
