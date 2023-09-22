package edu.skku.streamingquiz.video;

import edu.skku.streamingquiz.quiz.Quiz;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String title;

    private String url;

    @OneToMany(mappedBy = "video",
            cascade = CascadeType.ALL)
    private List<Quiz> quizzes;

}
