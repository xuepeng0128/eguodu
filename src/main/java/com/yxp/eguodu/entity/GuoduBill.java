package com.yxp.eguodu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//果度账单类
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GuoduBill {
    private  String studentId; // 学生id
    private String billTime; // 入账时间
    private  int guoduCoin; //  果度币 （负数代表花出）
    private String memo;  // 说明
}
