package com.innovatis.lynx.user.service;

import com.innovatis.lynx.user.service.dto.UserDto;

/**
 * Created by Ramakrishna Chalasani on 2/10/2017.
 */
public interface UserService {

    UserDto getUser(String userName);

}
