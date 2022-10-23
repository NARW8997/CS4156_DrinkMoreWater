package com.cs4256.drinkmorewater.models;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class User {
    @TableId("user_id")
    private Integer userId;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private Integer type;
}
