package edu.skku.streamingquiz.video;

import edu.skku.streamingquiz.quiz.Quiz;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Video {
    @Id
    private Long id;

    private String title;

    private String url;

    @OneToMany(mappedBy = "video")
    private List<Quiz> quizzes;
}
