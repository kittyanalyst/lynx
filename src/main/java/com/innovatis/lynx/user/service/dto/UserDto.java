package com.innovatis.lynx.user.service.dto;

import java.io.Serializable;

/**
 * Created by Ramakrishna Chalasani 02/11/2017.
 */
public class UserDto implements Serializable {


    private static final long serialVersionUID = -4409705817464713688L;

    private String firstName;
    private String lastName;
    private String userName;
    private boolean active;


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }


    public static final class Builder {
        private String firstName;
        private String lastName;
        private String userName;
        private boolean active;

        private Builder() {
        }

        public static Builder anUserDto() {
            return new Builder();
        }

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder userName(String userName) {
            this.userName = userName;
            return this;
        }

        public Builder active(boolean active) {
            this.active = active;
            return this;
        }

        public UserDto build() {
            UserDto userDto = new UserDto();
            userDto.setFirstName(firstName);
            userDto.setLastName(lastName);
            userDto.setUserName(userName);
            userDto.setActive(active);
            return userDto;
        }
    }
}
