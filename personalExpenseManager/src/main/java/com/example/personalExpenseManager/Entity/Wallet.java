package com.example.personalExpenseManager.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
//@Table(name = "wallet")
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name can't be blank")
    @Size(min=2,max = 30)
    private String name;
    @Size(min=2,max = 30)
    private String accountNumber;
    @Size(max = 150)
    private String description;
    @Min(1)
    @Max(3)
    private Integer priority;//high=1,meduim=2,low=3
    private Double currentBalance;
    @OneToMany(cascade = CascadeType.REFRESH,fetch = FetchType.LAZY,mappedBy = "wallet")
    @JsonIgnore
    private List<Transaction> transactions;
//    @PrePersist
//     public void setBalance(){
//        this.currentBalance=new int(0);
//    }

}
