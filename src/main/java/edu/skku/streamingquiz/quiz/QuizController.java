package edu.skku.streamingquiz.quiz;

import edu.skku.streamingquiz.choice.Choice;
import edu.skku.streamingquiz.video.Video;
import edu.skku.streamingquiz.video.VideoDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    @GetMapping()
    public String getQuiz() {
        return "What is the answer to life, the universe, and everything?";
    }

    @GetMapping("/test/{quizId}")
    public Quiz testQuiz(@PathVariable Long quizId) {
        Choice choice1 = new Choice(1L, null, "1. 장고", 1, false);
        Choice choice2 = new Choice(2L, null, "2. 네스트", 2, false);
        Choice choice3 = new Choice(3L, null, "3. 스프링", 3, true);
        Choice choice4 = new Choice(4L, null, "4. 넥스트", 4, false);
        List<Choice> choiceList = new ArrayList<>();
        choiceList.add(choice1);
        choiceList.add(choice2);
        choiceList.add(choice3);
        choiceList.add(choice4);
        return new Quiz(1L,"자바 프레임워크는?", choiceList,"3","보기 중 자바 프레임워크는 스프링이다", null, 1);
    }

}
