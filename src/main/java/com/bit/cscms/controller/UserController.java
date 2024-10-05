package com.bit.cscms.controller;

import com.bit.cscms.dto.UserDTO;
import com.bit.cscms.model.User;
import com.bit.cscms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getallusers")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/getallusers/{id}")
    public User getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @PostMapping("/createuser")
    public User createUser(@RequestBody UserDTO userDTO) {
        return userService.createUser(userDTO);
    }

    @PutMapping("updateuser/{id}")
    public User updateUser(@PathVariable int id, @RequestBody UserDTO userDTO) {
        return userService.updateUser (id, userDTO);
    }

    @DeleteMapping("deleteuser/{id}")
    public void deleteUser(@PathVariable int id) {
        userService.deleteUser (id);
    }
}
