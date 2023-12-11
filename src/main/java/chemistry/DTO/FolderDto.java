package chemistry.DTO;

import chemistry.models.ImageFile;
import chemistry.models.Users;
import chemistry.models.VideoFile;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class FolderDto {
    private int id;
    private String name_folder;
    private List<ImageFileDto> imageFiles;
    private List<VideoFileDto> videoFiles;
}
