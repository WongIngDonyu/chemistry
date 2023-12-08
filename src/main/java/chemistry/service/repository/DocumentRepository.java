package chemistry.service.repository;

import chemistry.models.DocumentFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocumentRepository extends JpaRepository<DocumentFile, String> {
    List<DocumentFile> findByFileName(String file_name);
}
