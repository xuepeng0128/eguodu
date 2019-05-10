package com.yxp.eguodu.common;

import com.yxp.eguodu.entity.SchoolExamExcelTemplate;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;
import java.util.Map;

public class ExcelUtil {
    /**
     * 创建excel文档，
     *  list 数据
     * @param columnNames excel的列名
     * */
    public static HSSFWorkbook createExamTemplateWorkBook(String sheetName,List<SchoolExamExcelTemplate> list, String columnNames[]) {
        // 创建excel工作簿
        HSSFWorkbook wb = new HSSFWorkbook();
        // 创建第一个sheet页，并命名
        HSSFSheet sheet = wb.createSheet(sheetName);
        // 设置列宽
        for(int i=0;i<columnNames.length;i++){
               if ( i==0 || i== 2)
               {
                   sheet.setColumnWidth((short) i, (short) (0*60));
               }else {
                   sheet.setColumnWidth((short) i, (short) (50*60));
               }

        }

        // 创建第一行，并设置其单元格格式
        HSSFRow row = sheet.createRow((short) 0);
        row.setHeight((short)500);
        // 单元格格式(用于列名)
        HSSFCellStyle cs = wb.createCellStyle();
        HSSFFont f = wb.createFont();
        f.setFontName("宋体");
        f.setFontHeightInPoints((short) 10);
        f.setBold(true);
        cs.setFont(f);
        cs.setAlignment(HorizontalAlignment.CENTER);// 水平居中
        cs.setVerticalAlignment(VerticalAlignment.CENTER);// 垂直居中
        cs.setLocked(true);
        cs.setWrapText(true);//自动换行
        //设置列名
        for(int i=0;i<columnNames.length;i++){
            HSSFCell cell = row.createCell(i);
            cell.setCellValue(columnNames[i]);
            cell.setCellStyle(cs);
        }

        String nowStudentId ="";
        short nowStudentNameRow=1;

        //设置首行外,每行每列的值(Row和Cell都从0开始)
        for (short i = 1; i < list.size(); i++) {
            SchoolExamExcelTemplate tempexam =list.get(i-1);

            if (!nowStudentId.equals(""))
            {
                if (!nowStudentId.equals(tempexam.getStudentId()))
                {
                    // 合并名称
                    CellRangeAddress region = new CellRangeAddress(nowStudentNameRow, i, 1, 1);
                    sheet.addMergedRegion(region);
                    nowStudentId= tempexam.getStudentId();
                    nowStudentNameRow=i;

                }
            }

            HSSFRow row1 = sheet.createRow((short) i);
            String flag = "";
            //在Row行创建单元格
            for(short j=0;j<columnNames.length;j++){
                HSSFCell cell = row1.createCell(j);
                switch (j){
                    case 0 :
                        cell.setCellValue(tempexam.getStudentId());
                        break;
                    case 1 :
                        cell.setCellValue(tempexam.getStudentName());
                        break;
                    case 2:
                        cell.setCellValue(tempexam.getSubjectExamClassId());
                        break;
                    case 3:
                        cell.setCellValue(tempexam.getSubjectExamClassName());
                        break;
                    case 4:
                        cell.setCellValue(tempexam.getFullScore());
                        break;
                    case 5 :
                        cell.setCellValue(tempexam.getScore());
                        break;
                    default:
                        break;
                }
            }






        }
        return wb;
    }



    //生成并下载Excel
    public static void downloadExamTemplateWorkBook(String sheetName,List<SchoolExamExcelTemplate> list, String columnNames[],
                                        HttpServletResponse response) throws IOException {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        try {
            ExcelUtil.createExamTemplateWorkBook(sheetName,list,columnNames).write(os);
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte[] content = os.toByteArray();
        InputStream is = new ByteArrayInputStream(content);
        // 设置response参数
        response.reset();
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment;filename="+ new String((  "template.xls").getBytes(), "iso-8859-1"));
        ServletOutputStream out = response.getOutputStream();
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            bis = new BufferedInputStream(is);
            bos = new BufferedOutputStream(out);
            byte[] buff = new byte[2048];
            int bytesRead;
            while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
                bos.write(buff, 0, bytesRead);
            }
        } catch (final IOException e) {
            throw e;
        } finally {
            if (bis != null)
                bis.close();
            if (bos != null)
                bos.close();
        }
    }





}
