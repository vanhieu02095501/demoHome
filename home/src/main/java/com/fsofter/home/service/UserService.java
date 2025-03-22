package com.fsofter.home.service;


import com.fsofter.home.model.User;
import com.fsofter.home.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository ;

    public List<User> getAll(){
        List<User> results = userRepository.findAll();
        return results;
    }

    public Page<User> searchUsers(String keyword, int page, int size) {
        if (keyword == null || keyword.isEmpty()) {
            return userRepository.findAll(PageRequest.of(page, size));
        }
        return userRepository.findByEmailContainingOrFirstNameContainingOrLastNameContaining(
                keyword, keyword, keyword, PageRequest.of(page, size));
    }

    public void saveUser(@Valid User user){
        userRepository.save(user);
    }

}
