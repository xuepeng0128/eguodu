package com.yxp.eguodu.entity.excelTemp;


import com.yxp.eguodu.common.ExcelToTableField;

public class StudentExcel {
    private String studentPaperId;
    private String studentName;
    private String address ; // 家庭住址
    private String tel;

    //得到 excel 和 数据库表字段参照
    public  ExcelToTableField[]  getExcelTableFeilds()
    {
        return  new ExcelToTableField[] {
                new ExcelToTableField("身份证","studentPaperId"),
                new ExcelToTableField("联系电话","tel"),
                new ExcelToTableField("名称","teacherName"),
                new ExcelToTableField("家庭住址","address")
        };
    }

}
