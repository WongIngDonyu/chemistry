package chemistry.service;

import chemistry.DTO.ImageFileDto;
import chemistry.models.FolderArchive;
import chemistry.models.ImageFile;
import chemistry.service.repository.FolderRepository;
import chemistry.service.repository.ImageFileRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageFileService {
    private final ImageFileRepository imageFileRepository;
    private final FolderRepository folderRepository;

    public ImageFileService(ImageFileRepository imageFileRepository, FolderRepository folderRepository) {
        this.imageFileRepository = imageFileRepository;
        this.folderRepository = folderRepository;
    }
    public List<ImageFile> getAllImages() {
        return imageFileRepository.findAll();
    }
    public void addImage(ImageFileDto imageFileDto, String folderId) {
        ImageFile imageFile = new ImageFile();
        imageFile.setImagePath(imageFileDto.getImagePath());
        imageFile.setImage_name(imageFileDto.getImage_name());
        FolderArchive folder = folderRepository.findById(Integer.valueOf(folderId))
                .orElseThrow(() -> new RuntimeException("Folder not found with id: " + folderId));
        imageFile.setFolder(folder);
        imageFileRepository.save(imageFile);
    }
    public void deleteImage(String id){
        imageFileRepository.deleteById(id);
    }
}
