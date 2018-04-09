package be.vdab.crm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    //@RequestMapping("/")
    @GetMapping("/")
    public String root() {
        return "redirect:/index.html";
    }

    //@RequestMapping("/index.html")
    @GetMapping("/index.html")
    public String index() {
        return "index";
    }
}
