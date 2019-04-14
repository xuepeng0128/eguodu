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

   private String menuId; // 菜单编号
   private String  menuName ; // 菜单名称
   private List<Menu> subMenu ; // 上级菜单编号
   private String  url ; // 链接地址
   private List<Map<String,Boolean>>  powers; // 权限
   private int  kind; // 1.公司 ，2.学校，3.机构


}
