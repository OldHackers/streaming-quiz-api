package edu.skku.streamingquiz.video;

import com.fasterxml.jackson.annotation.JsonIgnore;
import edu.skku.streamingquiz.choice.Choice;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;

@Getter
public class CreateQuizRequest {

    private String question;

//    private List<Choice> choiceList;
    private Long videoId;

    private String answer;

    private String commentary;

    private Integer idx;
}
