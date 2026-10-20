package ru.nnov.nntu.vst.demo.services;

import ru.nnov.nntu.vst.demo.dto.UserDTO;
import ru.nnov.nntu.vst.demo.dto.UserTypeDTO;

import java.util.List;

public interface IEUserTypeService {
    UserTypeDTO createUserTypeDTO(UserTypeDTO userTypeDto);
    List<UserTypeDTO> getAllUserTypes();
}
