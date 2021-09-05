package com.example.personalExpenseManager.Service;

import com.example.personalExpenseManager.Entity.Users;
import com.example.personalExpenseManager.Repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UsersRepository usersRepository;

    public Users submitMetaDataOfUser(Users user) {
        return usersRepository.save(user);
    }

    public Users displayUserMetaData(String userid) {
        return usersRepository.findByUserId(userid);
    }
}
