package ru.nnov.nntu.vst.demo.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.nnov.nntu.vst.demo.dto.UserDTO;
import ru.nnov.nntu.vst.demo.dto.UserTypeDTO;
import ru.nnov.nntu.vst.demo.mapper.UserMapper;
import ru.nnov.nntu.vst.demo.mapper.UserTypeMapper;
import ru.nnov.nntu.vst.demo.models.EUser;
import ru.nnov.nntu.vst.demo.models.EUserType;
import ru.nnov.nntu.vst.demo.repository.EUserTypeJPARepository;
import ru.nnov.nntu.vst.demo.services.IEUserTypeService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class EUserTypeServiceImpl implements IEUserTypeService {
    private EUserTypeJPARepository userTypeRepository;

    public EUserTypeServiceImpl(EUserTypeJPARepository userTypeRepository) {
        this.userTypeRepository = userTypeRepository;
    }

    public UserTypeDTO createUserTypeDTO(UserTypeDTO userTypeDto) {
        EUserType eusertype = UserTypeMapper.mapToEUserType(userTypeDto);
        EUserType savedEUserType = userTypeRepository.save(eusertype);
        return UserTypeMapper.mapToUserTypeDTO(savedEUserType);
    }

    @Override
    public List<UserTypeDTO> getAllUserTypes() {
        List<EUserType> eusertypes = userTypeRepository.findAll();
        return eusertypes.stream()
                .map((usertype) -> UserTypeMapper.mapToUserTypeDTO(usertype))
                .collect(Collectors.toList());
    }
}