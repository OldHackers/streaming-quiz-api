package edu.skku.streamingquiz.quiz;

import edu.skku.streamingquiz.video.Video;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Quiz {
    @Id
    private Long id;

    private String question;

    private String answer;

    @ManyToOne
    private Video video;

}
