package ru.nnov.nntu.vst.demo.services;

import ru.nnov.nntu.vst.demo.dto.UserDTO;

import java.util.List;

public interface IEUserService {
    UserDTO createUserDTO (UserDTO userdto);
    UserDTO getUserById(Long userID);
    List<UserDTO> getUsersByName(String name);
    List<UserDTO> getAllUsers();
    List<UserDTO> getAllUsersWithQueryAnnotation();
    List<UserDTO> getAllUsersWithUserType();
    UserDTO updateUser(Long userID, UserDTO updatedUser);
    void deleteUser(Long userID);
    //List<UserDTO> generateUserList();
}
