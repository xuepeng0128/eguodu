package com.yxp.eguodu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class School {

    private String schoolId; // 学校编号
    private String schoolName; // 学校名称

    private float longitude; // 经度坐标
    private float latitude ; // 纬度坐标
    private String address; // 地址
    private String schoolStyle; // 1.小学，2.初中
    private Employee saleMan; // 业务员
    private Date regTime; // 注册时间
}
