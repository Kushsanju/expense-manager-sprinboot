package com.example.personalExpenseManager.Repository;

import com.example.personalExpenseManager.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {

    Users save(Users user);
    Users findByUserId(String userId);
}
