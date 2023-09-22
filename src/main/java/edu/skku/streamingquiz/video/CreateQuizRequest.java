package edu.skku.streamingquiz.video;

import lombok.Getter;

import java.util.List;

@Getter
public class CreateQuizRequest {

    private String question;

    private List<String> choiceList;

    private String answer;

    private String commentary;

    private Integer idx;
}
