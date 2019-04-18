package com.yxp.eguodu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CircleClass {
    private String  circleClassId;
    private String  pareClassId;
    private String circleClassName;
    private String icon;
    private String memo;
}
