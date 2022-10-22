package com.cs4256.drinkmorewater.services;

import com.cs4256.drinkmorewater.models.User;
import com.cs4256.drinkmorewater.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUserById(int userId) throws Exception {
        Optional<User> result = userRepository.findById(userId);

        if (result.isPresent()) {
            return result.get();
        } else {
            throw new Exception("specified user not found!");
        }
    }
}
