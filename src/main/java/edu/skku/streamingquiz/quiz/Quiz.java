package edu.skku.streamingquiz.quiz;

import edu.skku.streamingquiz.choice.Choice;
import edu.skku.streamingquiz.video.Video;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Quiz {
    @Id
    private Long id;

    private String question;

    @OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL)
    private List<Choice> choiceList;

    private String answer;

    private String commentary;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "video_id")
    private Video video;

    private Integer idx;

}
