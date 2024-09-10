package com.tp.quizAppMicroservices.repository;

import com.tp.quizAppMicroservices.Entity.Quiz;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


public interface QuizRepository extends MongoRepository<Quiz,String> {
}
