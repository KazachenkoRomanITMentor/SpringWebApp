package com.example.SpringWebApp.service;

import com.example.SpringWebApp.entity.User;
import com.example.SpringWebApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServices {

    final
    UserRepository userRepository;

    public UserServices(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> readAllUser(){
        return (List<User>) userRepository.findAll();
    }

    public User readUserById(Long id){
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()){
            return user.get();
        } else {
            throw new NullPointerException("User is null");
        }

    }

    public User createUser(User user){
        return userRepository.save(user);
    }

    public User updateUser(User user){
        Optional<User> optionalUpdatingUser = userRepository.findById(user.getId());
        if(optionalUpdatingUser.isPresent()){
            User updatingUser = optionalUpdatingUser.get();
            updatingUser.setAge(user.getAge());
            updatingUser.setName(user.getName());
            updatingUser.setSurname(user.getSurname());
            updatingUser.setEmail(user.getEmail());
            return userRepository.save(updatingUser);
        } else {
            throw new NullPointerException("User is null");
        }
    }

    public void deleteUserById(Long id){
        userRepository.deleteById(id);
    }
}
