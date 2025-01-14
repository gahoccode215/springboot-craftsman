package com.gahoccode.hello_world.controller;

import com.gahoccode.hello_world.dto.request.UserRequestDTO;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

//    @PostMapping(value = "/", headers = "apiKey=v1.0")
    @RequestMapping(method = RequestMethod.POST, path = "/", headers = "apiKey=v1.0")
    public String addUser(@RequestBody UserRequestDTO userRequestDTO){
        return "create user";
    }
    @PutMapping("/{userId}")
    public String updateUser(@PathVariable("userId") int id, @RequestBody UserRequestDTO userRequestDTO){
        System.out.println("Request updat userId= " + id);
        return "update user";
    }
    @PatchMapping("/{userId}")
    public String changeStatus(@PathVariable int userId, @RequestParam(required = false) boolean status){
        System.out.println("Request change user status, userId = " + userId);
        return "User status changed";
    }
    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable int userId){
        System.out.println("Request delete userId= " + userId);
        return "user deleted";
    }
    @GetMapping("/{userId}")
    public UserRequestDTO getUser(@PathVariable int userId){
        System.out.println("Request get user detail by id = " + userId);
        return new UserRequestDTO("hay", "minh", "phone@", "03251");
    }
    @GetMapping("/list")
    public List<UserRequestDTO> getAllUsers(@RequestParam(defaultValue = "0") int pageNo, @RequestParam(defaultValue = "5") int pageSize){
        return List.of(new UserRequestDTO("Minh", "DO", "a@", "123"), new UserRequestDTO("Tay", "Java", "b@", "234"));
    }
}
