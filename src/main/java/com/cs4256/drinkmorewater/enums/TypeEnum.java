package com.cs4256.drinkmorewater.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TypeEnum {
    ADMIN(0, "admin"),
    CUSTOMER(1, "customer"),
    ORDERAPP(2, "orderApp"),
    RESTAURANT(3, "restaurant_owner");

    @EnumValue
    private Integer type;
    private String typeName;
}
