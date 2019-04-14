package com.yxp.eguodu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

// 教师职务表

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rank {

    private String rankId;
    private String rankName;
    private List<Rank> subRank;
}
