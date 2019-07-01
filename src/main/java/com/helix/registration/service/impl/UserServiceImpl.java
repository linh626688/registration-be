package com.helix.registration.service.impl;

import com.helix.registration.model.RestError;
import com.helix.registration.model.dto.RestException;
import com.helix.registration.model.dto.RestResponseDTO;
import com.helix.registration.model.dto.RestResponseWrapper;
import com.helix.registration.model.dto.UserDTO;
import com.helix.registration.model.entity.User;
import com.helix.registration.repository.UserRepository;
import com.helix.registration.service.UserService;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    private MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();

    @Override
    public RestResponseDTO registerUser(UserDTO userDTO) {
        List<User> usersCheckEmail = userRepository.findAllByEmail(userDTO.getEmail());
        if (!CollectionUtils.isEmpty(usersCheckEmail)) {
            throw new RestException(RestError.EMAIL_IS_EXITS, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        List<User> usersCheckPhoneNumber = userRepository.findAllByPhoneNumber(userDTO.getPhoneNumber());
        if (!CollectionUtils.isEmpty(usersCheckPhoneNumber)) {
            throw new RestException(RestError.PHONE_NUMBER_IS_EXITS, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        MapperFacade mapper = mapperFactory.getMapperFacade();
        User user =  mapper.map(userDTO, User.class);
        userRepository.save(user);
        return RestResponseWrapper.wrapSuccessResponse(userDTO);
    }
}
