package com.bit.cscms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private int user_id;
    private String email;
    private String password;
    private String first_name;
    private String last_name;
    private String nic;
    private String phone_number;
    private String address;
    private String user_role;
}
