package com.tp.quizAppMicroservices.Entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(value = "quiz")
@Data
public class Quiz {

    @Id
    private String quizId;
    private String title;
    private List<Question> questions;

}
