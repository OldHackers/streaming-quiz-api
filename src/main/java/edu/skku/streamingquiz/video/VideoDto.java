package edu.skku.streamingquiz.video;

import edu.skku.streamingquiz.quiz.Quiz;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class VideoDto {
    private String url;
    private List<Quiz> quizzes;
}
