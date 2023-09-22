package edu.skku.streamingquiz.video;

import edu.skku.streamingquiz.choice.Choice;
import edu.skku.streamingquiz.quiz.Quiz;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/video")
@RequiredArgsConstructor
public class VideoController {

    private final VideoService videoService;
    @GetMapping("/{videoId}")
    public VideoDto video(@PathVariable Long videoId){
        return videoService.getVideoData(videoId);
    }
    @GetMapping("/test/{videoId}")
    public VideoDto testVideo(@PathVariable Long videoId){

        Quiz quiz1 = new Quiz(1L,"q1",new ArrayList<Choice>(),"ans1","comment1",new Video(), 1);
        Quiz quiz2 = new Quiz(2L,"q2",new ArrayList<Choice>(),"ans2","comment2",new Video(), 2);
        List<Quiz> quizzes =  new ArrayList<>();
        quizzes.add(quiz1);
        quizzes.add(quiz2);

        return VideoDto.builder()
                .url("https://www.youtube.com/watch?v=rFA6xkdIKVU")
                .quizzes(quizzes)
                .build();
    }

    @PostMapping("video")
    public String upload(@RequestBody UploadVideoRequest uploadVideoRequest){

        return "";
    }
}
