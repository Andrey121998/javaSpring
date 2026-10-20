package ru.nnov.nntu.vst.demo.mapper;

import ru.nnov.nntu.vst.demo.dto.UserTypeDTO;
import ru.nnov.nntu.vst.demo.models.EUserType;

import java.util.Optional;

public class UserTypeMapper {
    //Создаем userTypeDTO на основе значений атрибутов euser
    public static UserTypeDTO mapToUserTypeDTO(EUserType eusertype){
        return new UserTypeDTO(eusertype.getId(), eusertype.getName());
    }

    //Создаем eusertype на основе значений атрибутов userTypeDTO
    public static EUserType mapToEUserType(UserTypeDTO userTypeDTO){
        return new EUserType(userTypeDTO.getId(), userTypeDTO.getName());
    }
}
