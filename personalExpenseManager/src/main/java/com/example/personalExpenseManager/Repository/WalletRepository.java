package com.example.personalExpenseManager.Repository;

import com.example.personalExpenseManager.Entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WalletRepository extends JpaRepository<Wallet,Long> {

List<Wallet> findAllByOrderByPriority();

}
