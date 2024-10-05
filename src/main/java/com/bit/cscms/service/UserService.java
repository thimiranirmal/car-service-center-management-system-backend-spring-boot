package com.bit.cscms.service;

import com.bit.cscms.dto.UserDTO;
import com.bit.cscms.model.User;
import com.bit.cscms.repo.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepository;
    @Autowired
    private ModelMapper modelMapper;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(int id) {
        return userRepository.findById(id).orElse(null);
    }

    public User createUser(UserDTO userDTO) {
        User user = modelMapper.map(userDTO, User.class);
        return userRepository.save(user);
    }

    public User updateUser(int id, UserDTO userDTO) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            modelMapper.map(userDTO, user);
            user = userRepository.save(user);
        }
        return user;
    }

    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }
}
