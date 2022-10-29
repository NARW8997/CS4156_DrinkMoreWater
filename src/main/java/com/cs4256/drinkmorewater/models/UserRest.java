package com.cs4256.drinkmorewater.models;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserRest {
    private String firstName;
    private String restName;
}
