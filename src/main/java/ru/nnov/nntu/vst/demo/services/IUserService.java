package ru.nnov.nntu.vst.demo.services;

import ru.nnov.nntu.vst.demo.dto.UserDTO;

import java.util.List;

public interface IUserService {
    UserDTO createUserDTO (UserDTO userdto);
    UserDTO getUserById(Long userID);
    List<UserDTO> getAllUsers();
    UserDTO updateUser(Long userID, UserDTO updatedUser);
    void deleteUser(Long userID);
}
