package edu.skku.streamingquiz.video;

import edu.skku.streamingquiz.quiz.Quiz;
import edu.skku.streamingquiz.quiz.QuizRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class VideoService {
    private final VideoRepository videoRepository;
    private final QuizRepository quizRepository;

    public VideoDto getVideoData(UUID videoId) {
        Video video = videoRepository.findById(videoId).orElseThrow(IllegalAccessError::new);

        return VideoDto.builder()
                .url(video.getUrl())
                .quizzes(video.getQuizzes())
                .build();
    }

    public Video uploadVideo(UploadVideoRequest uploadVideoRequest) {
        Video video = Video.builder()
                .title(uploadVideoRequest.getTitle())
                .url(uploadVideoRequest.getUrl())
                .build();
        return videoRepository.save(video);
    }

    public void createQuiz(CreateQuizRequest createQuizRequest) {
        Video video = videoRepository.findById(createQuizRequest.getVideoId()).orElseThrow(IllegalAccessError::new);

        Quiz quiz = Quiz.builder()
                .video(video)
                .answer(createQuizRequest.getAnswer())
                .idx(createQuizRequest.getIdx())
                .commentary(createQuizRequest.getCommentary())
                .question(createQuizRequest.getQuestion())
                .build();
        quizRepository.save(quiz);
    }

//    public Video getVideoByUUID(UUID uuid) {
//        return videoRepository.findByUuid(uuid).get();
//    }

}
