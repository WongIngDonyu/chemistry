package chemistry.service.repository;

import chemistry.models.FolderArchive;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FolderRepository extends JpaRepository<FolderArchive,Integer> {
    List<FolderArchive> findAll();
    Optional<FolderArchive> findById(Integer id);
}
