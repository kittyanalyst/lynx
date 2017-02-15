package com.innovatis.lynx.user.domain;

import com.innovatis.lynx.platform.jpa.postgres.domain.AuditableEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Ramakrishna Chalasani on 02/09/2017.
 */

@Entity
@Table( name="LYNX_USER")
public class User  {

    @Id
    @Column (name="USER_ID")
    private long userId;

    @Column (name="USER_NAME")
    private String userName;

    @Column (name="PASSWORD")
    private String password;

    @Column (name="EMAIL")
    private String email;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public static final class Builder {
        private Long userId;
        private String userName;
        private String password;
        private String email;

        private Builder() {
        }

        public static Builder anUser() {
            return new Builder();
        }

        public Builder userId(Long userId) {
            this.userId = userId;
            return this;
        }

        public Builder userName(String userName) {
            this.userName = userName;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }


        public User build() {
            User user = new User();
            user.setUserId(userId);
            user.setUserName(userName);
            user.setPassword(password);
            user.setEmail(email);

            return user;
        }
    }
}
