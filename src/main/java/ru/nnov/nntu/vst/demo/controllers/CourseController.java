package ru.nnov.nntu.vst.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.nnov.nntu.vst.demo.models.Course;

@Controller
public class CourseController {

    @GetMapping("/coursee")
    public String getCourse(Model model) {
        Course course = new Course(1, "Админ", "admin@nntu.ru");
        model.addAttribute("course", course);
        return "course";
    }
}
