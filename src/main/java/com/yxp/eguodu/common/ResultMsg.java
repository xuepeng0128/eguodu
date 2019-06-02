package com.yxp.eguodu.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

//webapi返回值类
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultMsg {
    private Map Data;
    private String resultMsg;
    private String resultCode;
}
