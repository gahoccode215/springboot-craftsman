package com.gahoccode.identity_service.service;

import java.time.LocalDate;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.gahoccode.identity_service.dto.request.UserCreationRequest;
import com.gahoccode.identity_service.dto.response.UserResponse;
import com.gahoccode.identity_service.entity.User;
import com.gahoccode.identity_service.exception.AppException;
import com.gahoccode.identity_service.repository.UserRepository;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    private UserCreationRequest request;
    private UserResponse userResponse;
    private User user;
    private LocalDate dob;

    @BeforeEach
    void initData() {
        dob = LocalDate.of(1990, 5, 21);
        request = UserCreationRequest.builder()
                .username("John")
                .firstName("John")
                .lastName("Doe")
                .password("12345678")
                .dob(dob)
                .build();
        userResponse = UserResponse.builder()
                .id("cs53312s3112")
                .username("John")
                .firstName("John")
                .lastName("Doe")
                .dob(dob)
                .build();
        user = User.builder()
                .id("cs53312s3112")
                .username("John")
                .firstName("John")
                .lastName("Doe")
                .dob(dob)
                .build();
    }

    @Test
    void createUser_validRequest_success() {
        // WHEN
        Mockito.when(userRepository.existsByUsername(userResponse.getUsername()))
                .thenReturn(false);
        Mockito.when(userRepository.save(User.builder().build())).thenReturn(user);

        // WHEN
        var response = userService.createUser(request);

        // THEN
        Assertions.assertThat(response.getId()).isEqualTo("cs53312s3112");
        Assertions.assertThat(response.getUsername()).isEqualTo("john");
    }

    @Test
    void createUser_userExisted_fail() {
        // WHEN
        Mockito.when(userRepository.existsByUsername(userResponse.getUsername()))
                .thenReturn(true);

        // WHEN
        var exception = org.junit.jupiter.api.Assertions.assertThrows(
                AppException.class, () -> userService.createUser(request));
        Assertions.assertThat(exception.getErrorCode().getCode()).isEqualTo(1002);
    }
}
