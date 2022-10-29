package com.cs4256.drinkmorewater.models;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Bookmark {
    @TableId("mark_id")
    private Integer markId;
    private Integer userId;
    private Integer restId;
}
