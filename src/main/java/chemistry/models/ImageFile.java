package chemistry.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "imagefile")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ImageFile extends BaseEntity{
    @Column(name = "image_name")
    private String image_name;
    @Column(name = "imagePath")
    private String imagePath;

    @ManyToOne
    @JoinColumn(name = "folder_id", nullable = false)
    private FolderArchive folder;
}
