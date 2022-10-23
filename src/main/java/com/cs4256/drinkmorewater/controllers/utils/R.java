package com.cs4256.drinkmorewater.controllers.utils;

import lombok.Data;

/**
 * Use this class to unify controllers' return vale
 * @flag: indicate if the request is successfully access to
 * database and return the corresponding data
 * @data return the corresponding data, return null if failed
 */
@Data
public class R {
    private Boolean flag;
    private Object data;

    public R() {
    }

    public R(Boolean flag) {
        this.flag = flag;
    }

    public R(Boolean flag, Object data) {
        this.flag = flag;
        this.data = data;
    }
}