package edu.skku.streamingquiz.video;

import com.github.f4b6a3.uuid.UuidCreator;
import edu.skku.streamingquiz.quiz.Quiz;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
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
