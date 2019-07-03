package com.helix.registration.controller;

import com.helix.registration.model.dto.RestResponseDTO;
import com.helix.registration.model.dto.UserDTO;
import com.helix.registration.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/register")
    public RestResponseDTO doRegister(@RequestBody UserDTO userDTO) {
        return userService.registerUser(userDTO);
    }

}
