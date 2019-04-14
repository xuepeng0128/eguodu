package com.yxp.eguodu.common;

/**
 * excel 表头 和数据库 表字段名对照
 */
public class ExcelToTableField {
      private String excelFieldName;
      private String tableFieldName;

    public String getExcelFieldName() {
        return excelFieldName;
    }

    public void setExcelFieldName(String excelFieldName) {
        this.excelFieldName = excelFieldName;
    }

    public String getTableFieldName() {
        return tableFieldName;
    }

    public void setTableFieldName(String tableFieldName) {
        this.tableFieldName = tableFieldName;
    }

    public ExcelToTableField() {
    }

    public ExcelToTableField(String excelFieldName, String tableFieldName) {
        this.excelFieldName = excelFieldName;
        this.tableFieldName = tableFieldName;
    }
}
