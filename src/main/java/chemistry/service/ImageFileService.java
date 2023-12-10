package chemistry.service;

import chemistry.DTO.ImageFileDto;
import chemistry.models.ImageFile;
import chemistry.service.repository.ImageFileRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageFileService {
    private final ImageFileRepository imageFileRepository;

    public ImageFileService(ImageFileRepository imageFileRepository) {
        this.imageFileRepository = imageFileRepository;
    }
    public List<ImageFile> getAllImages() {
        return imageFileRepository.findAll();
    }
    public void addImage(ImageFileDto imageFileDto) {
        ImageFile imageFile = new ImageFile();
        imageFile.setImagePath(imageFileDto.getImagePath());
        imageFile.setImage_name(imageFileDto.getImage_name());
        imageFileRepository.save(imageFile);
    }
    public void deleteImage(String id){
        imageFileRepository.deleteById(id);
    }
}
