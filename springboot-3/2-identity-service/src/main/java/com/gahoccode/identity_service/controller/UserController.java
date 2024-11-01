package com.gahoccode.identity_service.controller;

import com.gahoccode.identity_service.dto.request.APIResponse;
import com.gahoccode.identity_service.dto.request.UserCreationRequest;
import com.gahoccode.identity_service.dto.request.UserUpdateRequest;
import com.gahoccode.identity_service.entity.User;
import com.gahoccode.identity_service.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping()
    public APIResponse<User> createUser(@RequestBody @Valid UserCreationRequest request){
        APIResponse<User> apiResponse = new APIResponse<>();
        apiResponse.setResult(userService.createUser(request));
        return apiResponse;
    }

    @GetMapping()
    public List<User> getUser(){
        return userService.getUsers();
    }
    @GetMapping("/{id}")
    public User getUser(@PathVariable String id){
        return userService.getUser(id);
    }
    @PutMapping("/{id}")
    public User updateUser(@PathVariable String id, @RequestBody @Valid  UserUpdateRequest request){
        return userService.updateUser(id, request);
    }
    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable String userId){
        userService.deleteUser(userId);
        return "User has been deleted";
    }
}
