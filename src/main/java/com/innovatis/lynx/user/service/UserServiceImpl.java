package com.innovatis.lynx.user.service;

import com.innovatis.lynx.platform.exceptions.DataNotFoundException;
import com.innovatis.lynx.platform.mapping.MapperFacade;
import com.innovatis.lynx.user.service.dto.UserDto;
import com.innovatis.lynx.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

/**
 * Created by  Ramakrishna Chalasani 02/10/2017.
 */
@Service ("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    MapperFacade mapperFacade;


    @Override
    @Transactional(readOnly = true)
    public UserDto getUser(String userName) {
        Assert.notNull(userName, "UserName must not be null.");
        return userRepository.findOneByUserName(userName).map(user -> mapperFacade.map(user, UserDto.class))
                .orElseThrow(() -> new DataNotFoundException(String.format("User not found for user id %s", userName)));
    }
}
