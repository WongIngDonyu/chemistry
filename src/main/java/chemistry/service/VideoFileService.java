package chemistry.service;

import chemistry.DTO.ImageFileDto;
import chemistry.DTO.VideoFileDto;
import chemistry.models.FolderArchive;
import chemistry.models.ImageFile;
import chemistry.models.VideoFile;
import chemistry.service.repository.FolderRepository;
import chemistry.service.repository.VideoFileRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoFileService {
    private final VideoFileRepository videoFileRepository;
    private final FolderRepository folderRepository;

    public VideoFileService(VideoFileRepository videoFileRepository, FolderRepository folderRepository) {
        this.videoFileRepository = videoFileRepository;
        this.folderRepository = folderRepository;
    }

    public List<VideoFile> getAllVideo() {
        return videoFileRepository.findAll();
    }

    public void addVideo(VideoFileDto videoFileDto, String folderId) {
        VideoFile videoFile = new VideoFile();
        videoFile.setVideoPath(videoFileDto.getVideoPath());
        videoFile.setVideo_name(videoFileDto.getVideo_name());
        FolderArchive folder = folderRepository.findById(Integer.valueOf(folderId))
                .orElseThrow(() -> new RuntimeException("Folder not found with id: " + folderId));
        videoFile.setFolder(folder);
        videoFileRepository.save(videoFile);
    }

    public void deleteVideo(String id){
        videoFileRepository.deleteById(id);
    }
}
