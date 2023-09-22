package edu.skku.streamingquiz.quiz;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    @GetMapping()
    public String getQuiz() {
        return "What is the answer to life, the universe, and everything?";
    }

}
