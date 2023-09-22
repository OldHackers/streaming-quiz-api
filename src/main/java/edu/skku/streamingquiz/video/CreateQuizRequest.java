package edu.skku.streamingquiz.video;

import com.fasterxml.jackson.annotation.JsonIgnore;
import edu.skku.streamingquiz.choice.Choice;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Getter
public class CreateQuizRequest {

    private String question;

//    private List<Choice> choiceList;
    private UUID videoId;

    private String answer;

    private String commentary;

    private Integer idx;
}
