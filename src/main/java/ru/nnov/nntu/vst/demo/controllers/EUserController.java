package ru.nnov.nntu.vst.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.nnov.nntu.vst.demo.dto.UserDTO;
import ru.nnov.nntu.vst.demo.services.IEUserService;
import ru.nnov.nntu.vst.demo.services.IEUserTypeService;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class EUserController {
    private IEUserService userService;

    public EUserController(IEUserService userService) {
        this.userService = userService;
    }

    //Добавляем пользователя
    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO){
        UserDTO savedUser = userService.createUserDTO(userDTO);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserByID(@PathVariable("id") Long userID){
        UserDTO userDTO = userService.getUserById((Long)userID);
        return ResponseEntity.ok(userDTO);
    }

    @GetMapping("/f/{name}")
    public ResponseEntity<List<UserDTO>> getUserByName(@PathVariable("name") String name){
        List<UserDTO> users = userService.getUsersByName(name);
        return ResponseEntity.ok(users);
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUser(){
        List<UserDTO> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/q")
    public ResponseEntity<List<UserDTO>> getAllUserWithQueryAnnotation(){
        List<UserDTO> users = userService.getAllUsersWithQueryAnnotation();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/ut")
    public ResponseEntity<List<UserDTO>> getAllUserWithUserType(){
        List<UserDTO> users = userService.getAllUsersWithUserType();
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