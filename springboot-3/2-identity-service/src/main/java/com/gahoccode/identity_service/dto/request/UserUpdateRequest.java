package com.gahoccode.identity_service.dto.request;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserUpdateRequest {
    private String username;
    @Size(min = 8, message = "Password must be at least 8 characters.")
    private String password;
    private String firstName;
    private String lastName;
    private LocalDate dob;
    List<String> roles;


}
