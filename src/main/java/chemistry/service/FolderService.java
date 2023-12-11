package chemistry.service;

import chemistry.DTO.FolderDto;
import chemistry.DTO.FolderShowDto;
import chemistry.models.FolderArchive;
import chemistry.service.repository.FolderRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FolderService{
    private FolderRepository folderRepo;
    final ModelMapper modelMapper;

    @Autowired
    public void setFolderRepo(FolderRepository folderRepo) {
        this.folderRepo = folderRepo;
    }

    @Autowired
    public FolderService(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public List<FolderShowDto> getAllFolders() {
        return folderRepo.findAll().stream().map((c)->modelMapper.map(c,FolderShowDto.class)).collect(Collectors.toList());
    }
    public FolderDto getFolderById(int id) {
        Optional<FolderArchive> folderOptional = folderRepo.findById(id);
        FolderArchive folderArchive = folderOptional.orElseThrow(() -> new RuntimeException("Folder not found with id: " + id));
        return modelMapper.map(folderArchive, FolderDto.class);
    }
    public FolderDto addFolder(FolderDto folderDto) {
        FolderArchive folderArchive = modelMapper.map(folderDto, FolderArchive.class);
        folderArchive.setUser(null);
        FolderArchive savedFolder = folderRepo.save(folderArchive);
        return modelMapper.map(savedFolder, FolderDto.class);
    }
    public void deleteFolder(String id){
        folderRepo.deleteById(Integer.valueOf(id));
    }

}
