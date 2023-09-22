package edu.skku.streamingquiz.video;

import edu.skku.streamingquiz.choice.Choice;
import edu.skku.streamingquiz.quiz.Quiz;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class VideoServiceTest {

    @Autowired VideoService videoService;

//    @AfterEach
//    void afterEach() {
//        videoRepository.;
//    }

    @Test
    void getVideoData() {
        //given

        //when

        //then
    }
}