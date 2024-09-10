package com.tp.quizAppMicroservices.repository;

import com.tp.quizAppMicroservices.Entity.Question;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface QuestionRepository extends MongoRepository<Question,String> {

    @Query("{ 'category': ?0 }")
    public List<Question> findQuestionsByCategory(String category);
}
