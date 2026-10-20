package ru.nnov.nntu.vst.demo.services;

import ru.nnov.nntu.vst.demo.models.User;

import java.util.ArrayList;
import java.util.List;

public class UserCRUDService {
    List<User> userDb = new ArrayList<>();

    public UserCRUDService() {
        // Начальное состояние базы данных
        userDb.add(new User(1, "Админ", "admin@nntu.ru"));
        userDb.add(new User(2, "Админ2", "admin2@nntu.ru"));
    }

    public int getLastId(){
        return userDb.get(userDb.size() - 1).getId();
    }

    public List<User> getUserDb() {
        return userDb;
    }

    public void setUserDb(List<User> userDb) {
        this.userDb = userDb;
    }

    // Метод добавления пользователя
    public void insert(User user) {
        userDb.add(user);
    }

    // Обновляем информацию о пользователе
    public void update(int userId, User user) {
        userDb.set(userId, user);
    }

}
