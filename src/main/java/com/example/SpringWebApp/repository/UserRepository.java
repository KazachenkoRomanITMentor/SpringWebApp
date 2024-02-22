package com.example.SpringWebApp.repository;

import com.example.SpringWebApp.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
