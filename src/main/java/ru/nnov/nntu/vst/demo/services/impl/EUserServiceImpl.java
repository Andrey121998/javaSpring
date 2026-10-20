package ru.nnov.nntu.vst.demo.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.nnov.nntu.vst.demo.dto.UserDTO;
import ru.nnov.nntu.vst.demo.dto.UserTypeDTO;
import ru.nnov.nntu.vst.demo.exceptions.ResourceEmptyListException;
import ru.nnov.nntu.vst.demo.exceptions.ResourceNotFoundException;
import ru.nnov.nntu.vst.demo.mapper.UserMapper;
import ru.nnov.nntu.vst.demo.mapper.UserTypeMapper;
import ru.nnov.nntu.vst.demo.models.EUser;
import ru.nnov.nntu.vst.demo.repository.EUserJPARepository;
import ru.nnov.nntu.vst.demo.services.IEUserService;
import ru.nnov.nntu.vst.demo.services.IEUserTypeService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class EUserServiceImpl implements IEUserService {

   // private IEUserTypeService userTypeService;
    private EUserJPARepository userRepository;

    public EUserServiceImpl(EUserJPARepository userRepository) {
        this.userRepository = userRepository;
    }

  /*  public EUserServiceImpl(IEUserTypeService userTypeService, EUserJPARepository userRepository) {
        this.userTypeService = userTypeService;
        this.userRepository = userRepository;
    }*/

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
    public List<UserDTO> getUsersByName(String name) {
        List<EUser> eusers = userRepository.findUsersByName(name)
               .orElseThrow(() -> new ResourceEmptyListException("Пользователей с именем = "+name+" не существует."));

        return eusers.stream()
                .map((user) -> UserMapper.mapToUserDTO(user))
                .collect(Collectors.toList());
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<EUser> eusers = userRepository.findAll();
        return eusers.stream()
                     .map((user) -> UserMapper.mapToUserDTO(user))
                     .collect(Collectors.toList());
    }

    @Override
    public List<UserDTO> getAllUsersWithQueryAnnotation() {
        List<EUser> eusers = userRepository.findAllUsersWithQueryAnnotation();
        return eusers.stream()
                .map((user) -> UserMapper.mapToUserDTO(user))
                .collect(Collectors.toList());
    }

    @Override
    public List<UserDTO> getAllUsersWithUserType() {
        List<EUser> eusers = userRepository.findAllUsersWithUserType();
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


   /* @Transactional
    public void insertWithEntityManager(EUser user) {
        this.entityManager.persist(user);
    }*/

    /* @Override
   public List<UserDTO> generateUserList(){
        List<EUser> euserList = new ArrayList<>();
        List<UserDTO> savedUserList = new ArrayList<>();

        List<UserTypeDTO> savedUserTypes = userTypeService.generateUserTypeList();

        euserList.add(UserMapper.mapToEUser(new UserDTO((long)1, UserTypeMapper.mapToEUserType(savedUserTypes.get(0)),"trueUser", "trueUser@nntu.ru")));
        euserList.add(UserMapper.mapToEUser(new UserDTO((long)2, UserTypeMapper.mapToEUserType(savedUserTypes.get(0)),"slowUser", "slowUser@nntu.ru")));
        euserList.add(UserMapper.mapToEUser(new UserDTO((long)3, UserTypeMapper.mapToEUserType(savedUserTypes.get(1)),"fastUser", "fastUser@nntu.ru")));
        euserList.add(UserMapper.mapToEUser(new UserDTO((long)4, UserTypeMapper.mapToEUserType(savedUserTypes.get(1)),"youngUser", "youngUser@nntu.ru")));
        euserList.add(UserMapper.mapToEUser(new UserDTO((long)5, UserTypeMapper.mapToEUserType(savedUserTypes.get(2)),"oldUser", "oldUser@nntu.ru")));

        for (EUser euser: euserList){
            savedUserList.add(UserMapper.mapToUserDTO(userRepository.save(euser)));
        }

        return savedUserList;
    }*/
}