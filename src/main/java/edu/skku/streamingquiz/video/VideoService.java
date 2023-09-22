package edu.skku.streamingquiz.video;

import edu.skku.streamingquiz.quiz.QuizRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VideoService {
    private final VideoRepository videoRepository;
    private final QuizRepository quizRepository;

    public VideoDto getVideoData(Long videoId) {
        Video video = videoRepository.findById(videoId).orElseThrow(IllegalAccessError::new);

        return VideoDto.builder()
                .url(video.getUrl())
                .quizzes(video.getQuizzes())
                .build();
    }
}
