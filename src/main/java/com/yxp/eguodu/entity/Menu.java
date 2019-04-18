package com.yxp.eguodu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Menu {

   private String menuId;
   private String menuName;
   private String pareMenuId;
   private String url;
   private String icon;
   private String power;
   private int    paixu;
   private int   kind; // 1.公司 ，2.学校，3.机构




}
