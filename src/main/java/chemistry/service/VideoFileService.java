package chemistry.service;

import chemistry.DTO.ImageFileDto;
import chemistry.DTO.VideoFileDto;
import chemistry.models.ImageFile;
import chemistry.models.VideoFile;
import chemistry.service.repository.VideoFileRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoFileService {
    private final VideoFileRepository videoFileRepository;

    public VideoFileService(VideoFileRepository videoFileRepository) {
        this.videoFileRepository = videoFileRepository;
    }

    public List<VideoFile> getAllVideo() {
        return videoFileRepository.findAll();
    }
    public void addVideo(VideoFileDto videoFileDto) {
        VideoFile videoFile = new VideoFile();
        videoFile.setVideoPath(videoFileDto.getVideoPath());
        videoFile.setVideo_name(videoFileDto.getVideo_name());
        videoFileRepository.save(videoFile);
    }
    public void deleteVideo(String id){
        videoFileRepository.deleteById(id);
    }
}
