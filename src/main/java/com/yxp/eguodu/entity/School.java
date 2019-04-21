package com.yxp.eguodu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class School {


    private String schoolId; // 学校编号
    private String schoolName; // 学校名称
    private String cityId;
    private String districtId;
    private float longitude; // 经度坐标
    private float latitude ; // 纬度坐标
    private String address; // 地址
    private int schoolStyle; // 1.小学，2.初中
    private String saleManId; // 业务员
    private String tel;
    private String linkMan;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private  Date regTime; // 注册时间
    private boolean train;
}
