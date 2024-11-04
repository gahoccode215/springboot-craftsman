package com.gahoccode.identity_service.dto.response;

import com.gahoccode.identity_service.enums.Role;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.sql.Date;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserResponse {
    String id;
    String username;
    String firstName;
    String lastName;
    Date dob;
    Set<Role> roles;
}
