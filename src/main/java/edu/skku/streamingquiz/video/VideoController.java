package edu.skku.streamingquiz.video;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/video")
@RequiredArgsConstructor
public class VideoController {

    private final VideoService videoService;
    @GetMapping("/{videoId}")
    public VideoDto video(@PathVariable Long videoId){
        return videoService.getVideoData(videoId);
    }
}
