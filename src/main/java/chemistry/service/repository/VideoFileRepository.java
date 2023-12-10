package chemistry.service.repository;

import chemistry.models.VideoFile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoFileRepository extends JpaRepository<VideoFile, String> {

}
