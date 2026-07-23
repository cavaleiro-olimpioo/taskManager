package com.olimpio.taskmanager.service;

import com.olimpio.taskmanager.Repositories.UserRepository;
import com.olimpio.taskmanager.models.UserModel;
import org.springframework.stereotype.Service;

@Service
public class SignService {

    private UserRepository userRepository;

    public SignService(UserRepository userRepository) { this.userRepository = userRepository; }


    public void createAccount(String email, String username, String first_name, String last_name, String password) {
        UserModel newUser = new UserModel();
        newUser.setEmail(email);
        newUser.setUsername(username);
        newUser.setFirstName(first_name);
        newUser.setLastName(last_name);
        newUser.setPassword(password);
        userRepository.save(newUser);

    }
}
