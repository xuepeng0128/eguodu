package com.yxp.eguodu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SystemParams {
    private int  upperLimitGuodubi;
    private List<Integer> setPutCardGuodubiGrades;
    private Map<String , Integer> honerSet;
}
