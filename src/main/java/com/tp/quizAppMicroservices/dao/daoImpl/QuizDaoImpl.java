package com.tp.quizAppMicroservices.dao.daoImpl;

import com.tp.quizAppMicroservices.Entity.Question;
import com.tp.quizAppMicroservices.Entity.Quiz;
import com.tp.quizAppMicroservices.dao.QuizDao;
import com.tp.quizAppMicroservices.repository.QuizRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.TypedAggregation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.NoSuchElementException;

@Component
@RequiredArgsConstructor
@Repository
public class QuizDaoImpl implements QuizDao {

    private final QuizRepository quizRepository;
    private final MongoTemplate mongoTemplate;

    @Override
    public List<Question> getRandomQuestionsByCategory(String category, int numberOfQuestions) {
        TypedAggregation<Question> agg = Aggregation.newAggregation(
                Question.class,
                Aggregation.match(Criteria.where("category").is(category)),
                Aggregation.sample(numberOfQuestions)
        );

        return mongoTemplate.aggregate(agg, Question.class).getMappedResults();
    }

    @Override
    public Quiz createQuiz(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    @Override
    public Quiz getQuizById(String quizId) {
        return quizRepository.findById(quizId).orElseThrow(() -> new NoSuchElementException("No quiz found with id: " + quizId));
    }
}
