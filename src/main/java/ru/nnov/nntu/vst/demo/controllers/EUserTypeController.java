package ru.nnov.nntu.vst.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.nnov.nntu.vst.demo.dto.UserDTO;
import ru.nnov.nntu.vst.demo.dto.UserTypeDTO;
import ru.nnov.nntu.vst.demo.services.IEUserTypeService;

import java.util.List;

@RestController
@RequestMapping("api/usertypes")
public class EUserTypeController {
    private IEUserTypeService userTypeService;

    public EUserTypeController(IEUserTypeService userTypeService) {
        this.userTypeService = userTypeService;
    }

    //Добавляем тип пользователя
    @PostMapping
    public ResponseEntity<UserTypeDTO> createUserType(@RequestBody UserTypeDTO userTypeDTO){
        UserTypeDTO savedUserType = userTypeService.createUserTypeDTO(userTypeDTO);
        return new ResponseEntity<>(savedUserType, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<UserTypeDTO>> getAllUser(){
        List<UserTypeDTO> usertypes = userTypeService.getAllUserTypes();
        return ResponseEntity.ok(usertypes);
    }
}
