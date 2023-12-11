package chemistry.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "folder_archive")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FolderArchive extends BaseEntity{
    @Column(name = "name_folder")
    private String name_folder;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;

    @OneToMany(mappedBy = "folder", cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.EAGER)
    private List<ImageFile> imageFiles;

    @OneToMany(mappedBy = "folder", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<VideoFile> videoFiles;
}
