package chemistry.DTO;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class VideoFileDto {
    private String video_name;
    private String videoPath;
    private String folderId;
}
