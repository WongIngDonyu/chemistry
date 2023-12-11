package chemistry.web;

import chemistry.DTO.DocumentFileDto;
import chemistry.DTO.FolderDto;
import chemistry.DTO.ImageFileDto;
import chemistry.DTO.VideoFileDto;
import chemistry.service.DocumentService;
import chemistry.service.FolderService;
import chemistry.service.ImageFileService;
import chemistry.service.VideoFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequestMapping("/rutmuseum.ru/admin")
public class AdminController {
    private VideoFileService videoFileService;
    private ImageFileService imageFileService;
    private DocumentService documentService;
    private FolderService folderService;
    @Autowired
    public void setVideoFileService(VideoFileService videoFileService) {
        this.videoFileService = videoFileService;
    }
    @Autowired
    public void setImageFileService(ImageFileService imageFileService) {
        this.imageFileService = imageFileService;
    }
    @Autowired
    public void setDocumentService(DocumentService documentService) {
        this.documentService = documentService;
    }
    @Autowired
    public void setFolderService(FolderService folderService){this.folderService = folderService;}

    @GetMapping("/adminboard")
    public String adminBoard(Model model, Principal principal, VideoFileDto videoFileDto, ImageFileDto imageFileDto, DocumentFileDto documentFileDto, FolderDto folderDto){
        if (principal != null) {
            model.addAttribute("username", principal.getName());
        }
        model.addAttribute("pictures", imageFileService.getAllImages());
        model.addAttribute("videos", videoFileService.getAllVideo());
        model.addAttribute("folders", folderService.getAllFolders());
        model.addAttribute("documents", documentService.getAllDocuments());
        model.addAttribute("videoFileDto",videoFileDto);
        model.addAttribute("imageFileDto",imageFileDto);
        model.addAttribute("documentFileDto",documentFileDto);
        model.addAttribute("folderDto", folderDto);
        return "adminBoard";
    }

    @PostMapping("/addVideo")
    public String addDoc(VideoFileDto videoFileDto, @RequestParam("folderId") String folderId){
        videoFileService.addVideo(videoFileDto, folderId);
        return "redirect:/rutmuseum.ru/admin/adminboard";
    }

    @PostMapping("/addImage")
    public String addDoc2(ImageFileDto imageFileDto, @RequestParam("folderId") String folderId) {
        imageFileService.addImage(imageFileDto, folderId);
        return "redirect:/rutmuseum.ru/admin/adminboard";
    }

    @PostMapping("/addFolder")
    public String addDoc3(FolderDto folderDto){
        folderService.addFolder(folderDto);
        return "redirect:/rutmuseum.ru/admin/adminboard";
    }

    @PostMapping("/addDocument")
    public String addDocument(@ModelAttribute DocumentFileDto documentDto) {
        documentService.addDocument(documentDto);
        return "redirect:/rutmuseum.ru/admin/adminboard";
    }

    @PostMapping("/delete/{entity}/{id}")
    public String deleteEntity(@PathVariable String entity, @PathVariable String id) {
        if ("pictures".equals(entity)) {
            imageFileService.deleteImage(id);
        } else if ("video".equals(entity)) {
            videoFileService.deleteVideo(id);
        } else if ("folders".equals(entity)){
            folderService.deleteFolder(id);
        } else if ("documents".equals(entity)){
            documentService.deleteDocument(id);
        }
        return "redirect:/rutmuseum.ru/admin/adminboard";
    }

}
