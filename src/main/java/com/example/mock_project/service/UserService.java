package com.example.mock_project.service;

import com.example.mock_project.entities.Book;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import com.example.mock_project.entities.User;
import com.example.mock_project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author Admin
 */
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User getUserByID(Integer id) {
        return userRepository.getUserById(id);
    }
    public User getUserByUserName(String userName) {
        return userRepository.getUserByUsername(userName);
    }

    public List<User> findAllUser() {
        return userRepository.findAll();
    }

    public User updateUserEntity(int id, User user){
        User newUser = userRepository.getUserById(id);
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setEmail(user.getEmail());
        newUser.setPhone(user.getPhone());
        newUser.setGender(user.getGender());
        return userRepository.save(newUser);
    }
    public long countUsers() {
        long temp = userRepository.count();
        System.out.println("====================" + temp);
        return temp;
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }
}
