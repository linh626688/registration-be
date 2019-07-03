package com.helix.registration.service;

import com.helix.registration.model.dto.RestResponseDTO;
import com.helix.registration.model.dto.UserDTO;

public interface UserService {
    RestResponseDTO registerUser(UserDTO userDTO);
}
