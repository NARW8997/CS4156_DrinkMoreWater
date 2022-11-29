package com.cs4256.drinkmorewater.controllers.utils;

import com.cs4256.drinkmorewater.enums.TypeEnum;
import com.cs4256.drinkmorewater.services.impl.UserServiceImpl;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;

@Data
@AllArgsConstructor
public class UserType {
//    @Autowired
//    private UserServiceImpl userService;
    private Integer uid;
    private TypeEnum typeEnum;
//    public UserType(Integer uid) {
//        this.uid = uid;
//        typeEnum = userService.getById(uid).getType();
//    }

}
