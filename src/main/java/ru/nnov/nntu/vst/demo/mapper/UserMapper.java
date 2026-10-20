package ru.nnov.nntu.vst.demo.mapper;

import ru.nnov.nntu.vst.demo.dto.UserDTO;
import ru.nnov.nntu.vst.demo.models.EUser;

public class UserMapper {

    //Создаем userDTO на основе значений атрибутов euser
    public static UserDTO mapToUserDTO(EUser euser){
        return new UserDTO(euser.getId(), euser.getName(), euser.getEmail());
    }

    //Создаем euser на основе значений атрибутов userDTO
    public static EUser mapToEUser(UserDTO userDTO){
        return new EUser(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
    }
}
