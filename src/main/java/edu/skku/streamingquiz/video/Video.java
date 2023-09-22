package edu.skku.streamingquiz.video;

import edu.skku.streamingquiz.quiz.Quiz;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Video {
    @Id
    private Long id;

    private String title;

    private String url;

    @OneToMany(mappedBy = "video",
            cascade = CascadeType.ALL)
    private List<Quiz> quizzes;
}
