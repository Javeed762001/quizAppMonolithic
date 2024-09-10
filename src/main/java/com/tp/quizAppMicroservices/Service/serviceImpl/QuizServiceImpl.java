package com.tp.quizAppMicroservices.Service.serviceImpl;

import com.tp.quizAppMicroservices.Entity.ApiResponse;
import com.tp.quizAppMicroservices.Entity.Question;
import com.tp.quizAppMicroservices.Entity.Quiz;
import com.tp.quizAppMicroservices.Service.QuizService;
import com.tp.quizAppMicroservices.dao.QuizDao;
import com.tp.quizAppMicroservices.dto.QuestionDto;
import com.tp.quizAppMicroservices.dto.ResponseDto;
import com.tp.quizAppMicroservices.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class QuizServiceImpl implements QuizService {

    private final QuizDao quizDao;

    @Override
    public ResponseEntity<ApiResponse> createQuiz(String category, int noOfQuestions, String title) {

        Quiz quiz = new Quiz();
        quiz.setTitle(title);

        List<Question> questionsList = quizDao.getRandomQuestionsByCategory(category, noOfQuestions);
        quiz.setQuestions(questionsList);

        Quiz savedQuiz = quizDao.createQuiz(quiz);
        return ResponseUtil.getOkResponse(savedQuiz);
    }

    @Override
    public ResponseEntity<ApiResponse> getQuizQuestions(String quizId) {

        Quiz quiz = quizDao.getQuizById(quizId);
        List<Question> questionsList = quiz.getQuestions();

        List<QuestionDto> reqQuestionsList =new ArrayList<>();
        for(Question question: questionsList)
        {
            QuestionDto questionDto = new QuestionDto();
            questionDto.setId(question.getId());
            questionDto.setQuestionTitle(question.getQuestionTitle());
            questionDto.setOption1(question.getOption1());
            questionDto.setOption2(question.getOption2());
            questionDto.setOption3(question.getOption3());
            questionDto.setOption4(question.getOption4());

            reqQuestionsList.add(questionDto);
        }

        return ResponseUtil.getOkResponse(reqQuestionsList);
    }

    @Override
    public ResponseEntity<ApiResponse> calculateResult(String id, List<ResponseDto> responses) {

        Quiz quiz = quizDao.getQuizById(id);
        List<Question> questions= quiz.getQuestions();

        int totalScore = 0;
        int i=0;

        for(ResponseDto response: responses)
        {
            if(response.getResponse().equals(questions.get(i).getRightAnswer()))
            {
                totalScore++;

            }
            i++;
        }
        return ResponseUtil.getOkResponse(totalScore);
    }
}
