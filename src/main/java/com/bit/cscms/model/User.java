package com.bit.cscms.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int user_id;
    private String email;
    private String password;
    private String first_name;
    private String last_name;
    private String nic;
    private String phone_number;
    private String address;
    private String user_role;

    @PrePersist
    public void setUserRole() {
        if (user_role == null) {
            user_role = "customer";
        }
    }

}
