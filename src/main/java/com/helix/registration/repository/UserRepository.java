package com.helix.registration.repository;

import com.helix.registration.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findAllByEmail(String email);
    List<User> findAllByPhoneNumber(String phoneNumber);
}
