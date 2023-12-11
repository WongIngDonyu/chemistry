package chemistry.service.repository;

import chemistry.models.DocumentFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DocumentRepository extends JpaRepository<DocumentFile, String> {
    Optional<DocumentFile> findByFileName(String file_name);
}
