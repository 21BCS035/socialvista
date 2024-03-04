package com.socialvista.socialmedia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.socialvista.socialmedia.models.User;

public interface UserRepository extends JpaRepository<User,Integer> {
    
}
