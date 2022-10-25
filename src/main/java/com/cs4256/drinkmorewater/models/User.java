package com.cs4256.drinkmorewater.models;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class User {
    public User(Integer userId, String firstName, String lastName, String email, String phone, Integer type) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.type = type;
    }

    @TableId("user_id")
    private Integer userId;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private Integer type;
}
