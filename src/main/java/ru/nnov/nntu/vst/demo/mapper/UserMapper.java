package ru.nnov.nntu.vst.demo.mapper;

import ru.nnov.nntu.vst.demo.dto.UserDTO;
import ru.nnov.nntu.vst.demo.models.EUser;

import java.util.Optional;

public class UserMapper {

    //Создаем userDTO на основе значений атрибутов euser
    public static UserDTO mapToUserDTO(EUser euser){

        return new UserDTO(euser.getId(),
                UserTypeMapper.mapToUserTypeDTO(euser.getUserType()),
                euser.getName(), euser.getEmail());

    }

    //Создаем euser на основе значений атрибутов userDTO
    public static EUser mapToEUser(UserDTO userDTO){
        return new EUser(userDTO.getId(),
                         UserTypeMapper.mapToEUserType(userDTO.getUserType()),
                         userDTO.getName(),
                         userDTO.getEmail());
    }
}
