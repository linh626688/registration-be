package com.helix.registration.service;

import com.helix.registration.model.dto.RestResponseDTO;
import com.helix.registration.model.dto.UserDTO;

import java.util.List;

public interface UserService {
    RestResponseDTO registerUser(UserDTO userDTO);
}
