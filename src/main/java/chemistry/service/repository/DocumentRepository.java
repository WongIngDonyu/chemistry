package chemistry.service.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import chemistry.models.DocumentFile;

public interface DocumentRepository extends MongoRepository<DocumentFile, String> {

}
