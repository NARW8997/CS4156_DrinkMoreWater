package com.cs4256.drinkmorewater.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRestReview {
    private String firstName;
    private String restName;
    private String content;
}
