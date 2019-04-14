package com.yxp.eguodu.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CorpDuty {

    private String corpDutyId;
    private String corpDutyName;
    private int master;
}
