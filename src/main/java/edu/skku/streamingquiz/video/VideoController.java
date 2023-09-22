package edu.skku.streamingquiz.video;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.skku.streamingquiz.choice.Choice;
import edu.skku.streamingquiz.quiz.Quiz;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/video")
@RequiredArgsConstructor
public class VideoController {

    private final VideoService videoService;
    @GetMapping("/{videoId}")
    public VideoDto video(@PathVariable UUID videoId){
        return videoService.getVideoData(videoId);
    }
    @GetMapping("/test/{videoId}")
    public VideoDto testVideo(@PathVariable UUID videoId) {

        Quiz quiz1 = new Quiz(1L,"q1", new ArrayList<>(),"ans1","comment1", null, 1);
        Quiz quiz2 = new Quiz(2L,"q2", new ArrayList<>(),"ans2","comment2", null, 2);

        List<Quiz> quizzes =  new ArrayList<>();
        quizzes.add(quiz1);
        quizzes.add(quiz2);

        return VideoDto.builder()
                .url("https://www.youtube.com/watch?v=rFA6xkdIKVU")
                .quizzes(quizzes)
                .build();
    }

    @PostMapping()
    public Video upload(@RequestBody UploadVideoRequest uploadVideoRequest){
        return videoService.uploadVideo(uploadVideoRequest);
    }

    @PostMapping("/{videoId}/quiz")
    public void createQuiz(@PathVariable Long videoId, @RequestBody CreateQuizRequest createQuizRequest) {
        videoService.createQuiz(createQuizRequest);
    }


//    @GetMapping("/{uuid}")
//    public VideoDto getVideoByUUID(@PathVariable UUID uuid){
//
//        Video video = videoService.getVideoByUUID(uuid);
//        return VideoDto.builder()
//                .url("https://www.youtube.com/watch?v=rFA6xkdIKVU")
//                .quizzes(video.getQuizzes())
//                .build();
//    }
}
