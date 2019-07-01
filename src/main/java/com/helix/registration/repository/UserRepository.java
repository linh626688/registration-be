package com.helix.registration.repository;

import com.helix.registration.model.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findAllByEmail(String email);
    List<User> findAllByPhoneNumber(String phoneNumber);
}
