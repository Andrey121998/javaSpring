package ru.nnov.nntu.vst.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.nnov.nntu.vst.demo.models.User;

@Controller
public class UserController {

    @GetMapping("/userr")
    public String getUser(Model model) {
        User user = new User(1, "Админ", "admin@nntu.ru");
        model.addAttribute("user", user);
        return "user";
    }
}
