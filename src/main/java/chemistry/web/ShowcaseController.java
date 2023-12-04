package chemistry.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/rutmuseum.ru/showcase")
public class ShowcaseController {
    @GetMapping("/")
    public String showcasePage() {
        return "vitrina";
    }
    @GetMapping("/vao2")
    public String showcaseExanate1() {
        return "vao2";
    }
    @GetMapping("/sio2")
    public String showcaseExanate2() {
        return "sio2";
    }
    @GetMapping("/nh4clo4")
    public String showcaseExanate3() {
        return "nh4clo4";
    }
    @GetMapping("/hpo3")
    public String showcaseExanate4() {
        return "hpo3";
    }
    @GetMapping("/bao2")
    public String showcaseExanate5() {
        return "bao2";
    }
    @GetMapping("/baco3")
    public String showcaseExanate6() {
        return "baco3";
    }

}
