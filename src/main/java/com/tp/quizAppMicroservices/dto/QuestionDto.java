package com.tp.quizAppMicroservices.dto;

import lombok.Data;

@Data
public class QuestionDto {

    String id;
    String questionTitle;
    String option1;
    String option2;
    String option3;
    String option4;
}
