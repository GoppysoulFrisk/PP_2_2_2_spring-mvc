package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import web.dao.UserDAO;

@Controller
public class TestController {

    @GetMapping("/test")
    public String TestController() {
        return "test";
    }
}
