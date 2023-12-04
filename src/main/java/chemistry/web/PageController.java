package chemistry.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/rutmuseum.ru")
public class PageController {
    @GetMapping("/about")
    public String aboutPage() {
        return "about";
    }
    @GetMapping("/contacts")
    public String contactsPage() {
        return "contacts";
    }
    @GetMapping("/excursion")
    public String excursionPage() {
        return "excursion";
    }
}
