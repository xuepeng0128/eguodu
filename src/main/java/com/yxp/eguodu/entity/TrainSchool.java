package com.yxp.eguodu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrainSchool {

    private String trainSchoolId; // 培训学校编号
    private String trainSchoolName; // 培训学校名称
    private TrainSchoolStyle trainSchoolStyle;
    private float longitude; // 经度坐标
    private float latitude ; // 纬度坐标
    private String address; // 地址
    private Employee saleMans; // 业务员
}
