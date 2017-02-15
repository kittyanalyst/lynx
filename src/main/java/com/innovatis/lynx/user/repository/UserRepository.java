package com.innovatis.lynx.user.repository;

import com.innovatis.lynx.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created by Ramakrishna Chalasani 02/10/2017.
 */
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findOneByUserName(String userName);
}
