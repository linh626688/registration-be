package com.helix.registration;

import com.helix.registration.model.dto.RestException;
import com.helix.registration.model.dto.RestResponseDTO;
import com.helix.registration.model.dto.UserDTO;
import com.helix.registration.model.entity.User;
import com.helix.registration.repository.UserRepository;
import com.helix.registration.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatcher;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {RegistrationApplication.class})
//@WebMvcTest
public class RegistrationApplicationTests {

    @MockBean
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

	@Test(expected = RestException.class)
	public void registerUser1() {
        UserDTO userDTO = new UserDTO();
        userDTO.setEmail("1234");
        Mockito.when(userRepository.findAllByEmail(userDTO.getEmail()))
                .thenReturn(Collections.singletonList(this.mockUser()));
        userService.registerUser(userDTO);
	}

	@Test(expected = RestException.class)
	public void registerUser2() {
        UserDTO userDTO = new UserDTO();
        userDTO.setPhoneNumber("1234");
        Mockito.when(userRepository.findAllByPhoneNumber(userDTO.getPhoneNumber()))
                .thenReturn(Collections.singletonList(this.mockUser()));
        userService.registerUser(userDTO);
	}

    @Test
    public void registerUser3() {
        UserDTO userDTO = new UserDTO();
        userDTO.setPhoneNumber("1234");
        RestResponseDTO restResponseDTO = userService.registerUser(userDTO);
        UserDTO userResponse = (UserDTO) (restResponseDTO.getBody());

        Assert.assertEquals(restResponseDTO.getHeader().getStatusCode(), "200");
        Assert.assertEquals( userResponse.getPhoneNumber(), "1234");
    }

	private User mockUser(){
	    User user = new User();
        user.setLastName("1234");
	    return user;
    }
}
