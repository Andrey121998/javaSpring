package ru.nnov.nntu.vst.demo.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.nnov.nntu.vst.demo.dto.UserDTO;
import ru.nnov.nntu.vst.demo.services.IUserService;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class EUserController {
    private IUserService userService;

    // Для внедрения сервиса работы с данными о пользователе userService
    public EUserController(IUserService userService) {
        this.userService = userService;
    }

    //Добавляем пользователя
    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO){
        UserDTO savedUser = userService.createUserDTO(userDTO);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<UserDTO> getUserByID(@PathVariable("id") Long userID){
        UserDTO userDTO = userService.getUserById(userID);
        return ResponseEntity.ok(userDTO);
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUser(){
        List<UserDTO> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @PutMapping("{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable("id") Long userID, @RequestBody UserDTO updatedUser){
        UserDTO userDto = userService.updateUser(userID, updatedUser);
        return ResponseEntity.ok(userDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long userID){
        userService.deleteUser(userID);
        return ResponseEntity.ok("Пользователь с ID = "+userID+ " успешно удален");
    }
}