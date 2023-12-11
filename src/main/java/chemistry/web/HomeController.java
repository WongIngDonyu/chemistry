package chemistry.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String homePage() {
        return "index";
    }

    @GetMapping("/rutmuseum.ru/lections")
    public String lections(){
        return "lections";
    }
}

