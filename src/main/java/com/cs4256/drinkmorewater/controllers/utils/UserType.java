package com.cs4256.drinkmorewater.controllers.utils;

import com.cs4256.drinkmorewater.enums.TypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;

@SuppressWarnings("CommentedOutCode")
@Data
@AllArgsConstructor
public class UserType {
//    @Autowired
//    private UserServiceImpl userService;
    @SuppressWarnings("CommentedOutCode")
    private Integer uid;
    private TypeEnum typeEnum;
//    public UserType(Integer uid) {
//        this.uid = uid;
//        typeEnum = userService.getById(uid).getType();
//    }
}
