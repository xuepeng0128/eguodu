package com.yxp.eguodu.entity.excelTemp;


import com.yxp.eguodu.common.ExcelToTableField;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TeacherExcel  {
    private String paperId; // 身份证
    private String tel; // 电话
    private String teacherName; // 老师姓名
    private String duty; // 职务
    //得到 excel 和 数据库表字段参照
    public  ExcelToTableField[]  getExcelTableFeilds()
    {
        return  new ExcelToTableField[] {
                new ExcelToTableField("身份证","paperId"),
                new ExcelToTableField("联系电话","tel"),
                new ExcelToTableField("名称","teacherName"),
                new ExcelToTableField("职务","duty")
        };
    }



}
