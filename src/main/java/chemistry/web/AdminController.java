package chemistry.web;

import chemistry.DTO.ImageFileDto;
import chemistry.DTO.VideoFileDto;
import chemistry.service.ImageFileService;
import chemistry.service.VideoFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/rutmuseum.ru/admin")
public class AdminController {
    private VideoFileService videoFileService;
    private ImageFileService imageFileService;
    @Autowired
    public void setVideoFileService(VideoFileService videoFileService) {
        this.videoFileService = videoFileService;
    }
    @Autowired
    public void setImageFileService(ImageFileService imageFileService) {
        this.imageFileService = imageFileService;
    }

    @GetMapping("/adminboard")
    public String adminBoard(Model model, VideoFileDto videoFileDto, ImageFileDto imageFileDto){
        model.addAttribute("pictures", imageFileService.getAllImages());
        model.addAttribute("videos", videoFileService.getAllVideo());
        model.addAttribute("videoFileDto",videoFileDto);
        model.addAttribute("imageFileDto",imageFileDto);
        return "adminBoard";
    }


    @PostMapping("/addVideo")
    public String addDoc(VideoFileDto videoFileDto){
        videoFileService.addVideo(videoFileDto);
        return "redirect:/rutmuseum.ru/admin/adminboard";
    }

    @PostMapping("/addImage")
    public String addDoc2(ImageFileDto imageFileDto){
        imageFileService.addImage(imageFileDto);
        return "redirect:/rutmuseum.ru/admin/adminboard";
    }

    @GetMapping("/delete/{entity}/{id}")
    public String deleteEntity(@PathVariable String entity, @PathVariable String id) {
        if ("pictures".equals(entity)) {
            imageFileService.deleteImage(id);
        } else if ("video".equals(entity)) {
            videoFileService.deleteVideo(id);
        }
        return "redirect:/rutmuseum.ru/admin/adminboard";
    }

}
