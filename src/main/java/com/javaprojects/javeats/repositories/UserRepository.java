package com.javaprojects.javeats.repositories;

import com.javaprojects.javeats.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Integer> {

    @Query("select u from Users u where u.username = :username ")
    public Optional<Users> findByUsername(String username);
}
