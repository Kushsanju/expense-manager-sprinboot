package com.example.personalExpenseManager.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.dao.DataAccessException;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Min(1)
    @NotNull(message = "amount can't be null")
    private Double amount;

    private String description;
    @Min(1)
    @Max(3)
    private int type;//1 income,2 expense,3 transfer
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date transactionDate;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="wallet_id",nullable = false)
    @JsonIgnore
    private Wallet wallet;
    @PrePersist
    public void setTransactionDate(){
        this.transactionDate=new Date();
    }

}
