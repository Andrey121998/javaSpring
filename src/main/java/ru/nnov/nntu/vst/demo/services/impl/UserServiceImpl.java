package ru.nnov.nntu.vst.demo.services.impl;

import org.springframework.stereotype.Service;
import ru.nnov.nntu.vst.demo.dto.UserDTO;
import ru.nnov.nntu.vst.demo.exceptions.ResourceNotFoundException;
import ru.nnov.nntu.vst.demo.mapper.UserMapper;
import ru.nnov.nntu.vst.demo.models.EUser;
import ru.nnov.nntu.vst.demo.repository.EUserJPARepository;
import ru.nnov.nntu.vst.demo.services.IUserService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements IUserService {
    private EUserJPARepository userRepository;

    public UserServiceImpl(EUserJPARepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDTO createUserDTO(UserDTO userDto) {
        EUser euser = UserMapper.mapToEUser(userDto);
        EUser savedEUser = userRepository.save(euser);
        return UserMapper.mapToUserDTO(savedEUser);
    }

    @Override
    public UserDTO getUserById(Long userID) {
        EUser euser = userRepository.findById(userID)
                .orElseThrow(() -> new ResourceNotFoundException("Пользователя с ID = "+userID+" не существует."));
        return UserMapper.mapToUserDTO(euser);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<EUser> eusers = userRepository.findAll();
        return eusers.stream()
                     .map((user) -> UserMapper.mapToUserDTO(user))
                     .collect(Collectors.toList());
    }

    @Override
    public UserDTO updateUser(Long userID, UserDTO updatedUser) {
        EUser euser = userRepository.findById(userID)
                      .orElseThrow(()->new ResourceNotFoundException("Пользователя с ID = "+userID+" не существует."));
        euser.setName(updatedUser.getName());
        euser.setEmail(updatedUser.getEmail());
        EUser updatedUserObj = userRepository.save(euser);
        return UserMapper.mapToUserDTO(updatedUserObj);
    }

    @Override
    public void deleteUser(Long userID) {
        EUser euser = userRepository.findById(userID)
                .orElseThrow(()->new ResourceNotFoundException("Пользователя с ID = "+userID+" не существует."));
        userRepository.deleteById(userID);
    }
}
