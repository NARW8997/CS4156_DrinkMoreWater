package com.cs4256.drinkmorewater.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TopRankDish {
    private Integer count;
    private String dishName;
}
