package edu.skku.streamingquiz.quiz;

import com.fasterxml.jackson.annotation.JsonIgnore;
import edu.skku.streamingquiz.choice.Choice;
import edu.skku.streamingquiz.video.Video;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String question;

    @OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL)
    private List<Choice> choiceList;

    private String answer;

    @Column(columnDefinition = "LONGTEXT")
    private String commentary;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "video_id")
    @JsonIgnore
    private Video video;

    private Integer idx;

}
