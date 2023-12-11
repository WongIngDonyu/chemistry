package chemistry.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class ImageFileDto {
    private String image_name;
    private String imagePath;
    private String folderId;
}
