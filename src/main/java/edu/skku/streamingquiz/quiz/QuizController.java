package edu.skku.streamingquiz.quiz;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuizController {

    @GetMapping("/quiz")
    public String getQuiz() {
        return "What is the answer to life, the universe, and everything?";
    }
}
