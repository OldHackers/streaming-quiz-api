package edu.skku.streamingquiz.video;

import edu.skku.streamingquiz.choice.Choice;
import edu.skku.streamingquiz.choice.ChoiceRepository;
import edu.skku.streamingquiz.quiz.Quiz;
import edu.skku.streamingquiz.quiz.QuizRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class VideoService {
    private final VideoRepository videoRepository;
    private final QuizRepository quizRepository;
    private final ChoiceRepository choiceRepository;

    public VideoDto getVideoData(UUID videoId) {
        Video video = videoRepository.findById(videoId).orElseThrow(IllegalAccessError::new);

        return VideoDto.builder()
                .url(video.getUrl())
                .title(video.getTitle())
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

    public void createQuiz(UUID videoId, CreateQuizRequest createQuizRequest) {
        Video video = videoRepository.findById(videoId).orElseThrow(IllegalAccessError::new);

        List<String> choiceContents = createQuizRequest.getChoiceList();

        Quiz quiz = Quiz.builder()
                .video(video)
                .answer(createQuizRequest.getAnswer())
                .idx(createQuizRequest.getIdx())
                .commentary(createQuizRequest.getCommentary())
                .question(createQuizRequest.getQuestion())
                .build();

        quizRepository.save(quiz);

        for (int i = 0; i < choiceContents.size(); i++) {
            Choice choice = Choice.builder()
                    .quiz(quiz)
                    .choiceNumber(i + 1)
                    .content(choiceContents.get(i))
                    .isAnswer(i + 1 == Integer.parseInt(quiz.getAnswer()))
                    .build();
            choiceRepository.save(choice);
        }
    }

    public void updateVideo(UUID videoId, UploadVideoRequest updateVideoRequest) {
        Video video = videoRepository.findById(videoId).orElseThrow(IllegalAccessError::new);
        video.setTitle(updateVideoRequest.getTitle());
        video.setUrl(updateVideoRequest.getUrl());
        videoRepository.save(video);
    }

//    public Video getVideoByUUID(UUID uuid) {
//        return videoRepository.findByUuid(uuid).get();
//    }

}
