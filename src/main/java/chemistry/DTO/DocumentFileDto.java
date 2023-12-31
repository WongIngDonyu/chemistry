package chemistry.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class DocumentFileDto {
    private String filePath;
    private String fileName;
    private long userId;
    private String imagePath;
}
