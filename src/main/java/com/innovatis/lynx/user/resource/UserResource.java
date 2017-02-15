package com.innovatis.lynx.user.resource;

import com.innovatis.lynx.user.service.UserService;
import com.innovatis.lynx.user.service.dto.UserDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ValidationException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * Created by Ramakrishna Chalasani 02/10/2017.
 */

@Api (value="users", description = "User Resource")
@Component ("usersResource")
@Path("/users")
public class UserResource {

    @Autowired
    UserService userService;


    @GET
    @Produces (MediaType.APPLICATION_JSON)
    public UserDto getUser (@ApiParam (name="username", value ="User Name to Login") @QueryParam("username") String userName) {

        //Validate username
        if (StringUtils.isEmpty(userName)) {
            throw new ValidationException ("User Name cannot be Empty: ");
        }
        return userService.getUser(userName);
    }

}
