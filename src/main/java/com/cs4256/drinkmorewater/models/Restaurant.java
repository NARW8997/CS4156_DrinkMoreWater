package com.cs4256.drinkmorewater.models;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
public class Restaurant {
    @TableId("rest_id")
    private Integer restId;
    private String location;
    private Integer type;
    private Integer likes;
    private Integer dislikes;
    private Integer restDislikes;
    private Integer restLikes;
    private String restLocation;
    private String restName;
    private String restNumber;
    private String restSize;
}