package ru.nnov.nntu.vst.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.nnov.nntu.vst.demo.models.User;
import ru.nnov.nntu.vst.demo.services.UserCRUDService;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserRestController {

    UserCRUDService userCRUDService = new UserCRUDService();

    @GetMapping("/user")
    public User getUser() {
        User user = new User(1, "Админ", "admin@nntu.ru");
        return user;
    }

 /*   @GetMapping("/users")
    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        users.add(new User(1, "Админ", "admin@nntu.ru"));
        users.add(new User(2, "Админ2", "admin2@nntu.ru"));

        return users;
    }*/

    @GetMapping("/users")
    public List<User> getUsers() {
        return userCRUDService.getUserDb();
    }

    @PostMapping("/user/{name}/{email}")
    public void addUsers(@PathVariable String name, @PathVariable String email) {
        userCRUDService.insert(new User(userCRUDService.getLastId()+1, name, email));
        System.out.println("Добавлен пользователь "+
                            userCRUDService.getUserDb().get(userCRUDService.getUserDb().size() - 1));
    };
}