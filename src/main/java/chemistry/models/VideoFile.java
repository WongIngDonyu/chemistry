package chemistry.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "videofile")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VideoFile extends BaseEntity{
    @Column(name = "video_name")
    private String video_name;
    @Column(name = "videoPath")
    private String videoPath;

    @ManyToOne
    @JoinColumn(name = "folder_id", nullable = false)
    private FolderArchive folder;
}
