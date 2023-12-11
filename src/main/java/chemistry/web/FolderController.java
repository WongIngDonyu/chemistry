package chemistry.web;

import chemistry.DTO.FolderDto;
import chemistry.DTO.FolderShowDto;
import chemistry.models.FolderArchive;
import chemistry.service.FolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/rutmuseum.ru/folders")
public class FolderController {
    private final FolderService folderService;
    @Autowired
    public FolderController(FolderService folderService) {
        this.folderService = folderService;
    }

    @GetMapping()
    public String listAllFolders(Model model) {
        List<FolderShowDto> folders = folderService.getAllFolders();
        model.addAttribute("folders", folders);
        return "folderlist";
    }

    @GetMapping("/{folderId}")
    public String viewFolder(Model model, @PathVariable int folderId) {
        FolderDto folder = folderService.getFolderById(folderId);
        model.addAttribute("folder", folder);
        return "folderinside";
    }
}

