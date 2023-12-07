package chemistry.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "document_files")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DocumentFile extends BaseEntity {
    @Column(name = "filePath")
    private String filePath;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;
}
