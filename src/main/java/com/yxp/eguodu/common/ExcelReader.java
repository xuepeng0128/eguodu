package com.yxp.eguodu.common;


/**
 * 操作Excel表格的功能类
 * @author：
 * @version
 */
public class ExcelReader {
//    private POIFSFileSystem fs;
//    private HSSFWorkbook wb;
//    private HSSFSheet sheet;
//    private HSSFRow row;
//
//    private XSSFWorkbook xwb;
//    private XSSFSheet xsheet;
//    private XSSFRow xrow;
//    /**
//     * 读取Excel表格表头的内容
//     * @param InputStream
//     * @return String 表头内容的数组
//     *
//     */
//    public String[] readExcelTitle(InputStream is,String sheetName) {
//        try {
//            fs = new POIFSFileSystem(is);
//            wb = new HSSFWorkbook(fs);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        if (sheetName ==null)
//        {
//        sheet = wb.getSheetAt(0);
//        }else  {
//        sheet = wb.getSheet(sheetName);
//        }
//
//
//        row = sheet.getRow(0);
//        //标题总列数
//        int colNum = row.getPhysicalNumberOfCells();
//        String[] title = new String[colNum];
//        for (int i=0; i<colNum; i++) {
//            title[i] = getTitleValue(row.getCell((short) i));
//        }
//        return title;
//    }
//
//    public String[] readExcelTitle2(FileInputStream  is,String sheetName) {
//        try {
//            xwb = new XSSFWorkbook(is);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        if (sheetName ==null) {
//        xsheet = xwb.getSheetAt(0);
//        }else {
//        xsheet = xwb.getSheet(sheetName);
//        }
//
//
//
//        xrow = xsheet.getRow(0);
//        //标题总列数
//        int colNum = xrow.getPhysicalNumberOfCells();
//        String[] title = new String[colNum];
//        for (int i=0; i<colNum; i++) {
//            title[i] = getTitleValue2(xrow.getCell((short) i));
//        }
//        return title;
//    }
//    /**
//     * 获取单元格数据内容为字符串类型的数据
//     * @param cell Excel单元格
//     * @return String 单元格数据内容，若为字符串的要加单引号
//     */
//    public String getStringCellValue(HSSFCell cell) {
//        String strCell = "";
//        switch (cell.getCellType()) {
//        case STRING:
//            strCell = "'" + cell.getStringCellValue() + "'";
//            break;
//        case NUMERIC:
//
//               strCell = String.valueOf((int)cell.getNumericCellValue());
//            break;
//        case BOOLEAN:
//            strCell = String.valueOf(cell.getBooleanCellValue());
//            break;
//        case BLANK:
//            strCell = "''";
//            break;
//        default:
//            strCell = "''";
//            break;
//        }
//        if (strCell.equals("''") || strCell == null) {
//            return "";
//        }
//        if (cell == null) {
//            return "";
//        }
//        return strCell;
//    }
//
//    public String getStringCellValue2(XSSFCell cell) {
//        String strCell = "";
//        switch (cell.getCellType()) {
//            case STRING:
//            strCell = "'" + cell.getStringCellValue() + "'";
//            break;
//        case NUMERIC:
//               strCell = "'" +String.valueOf((long)cell.getNumericCellValue())+ "'";
//            break;
//        case BOOLEAN:
//            strCell = String.valueOf(cell.getBooleanCellValue());
//            break;
//        case BLANK:
//            strCell = "''";
//            break;
//        default:
//            strCell = "''";
//            break;
//        }
//        if (strCell.equals("''") || strCell == null) {
//            return "";
//        }
//        return strCell;
//    }
//
//    public String getTitleValue(HSSFCell cell) {
//        String strCell =  cell.getStringCellValue();
//        return strCell;
//    }
//
//    public String getTitleValue2(XSSFCell cell) {
//        String strCell =  cell.getStringCellValue();
//        return strCell;
//    }
//
//
///**
//* 读取该单元格内容在第几列 xls
//* @param is
//* @param sheetName
//* @return
//*/
//private int readXlsColIndexBycell(InputStream is,String sheetName,String cellContent) {
//           try {
//                fs = new POIFSFileSystem(is);
//                wb = new HSSFWorkbook(fs);
//           } catch (IOException e) {
//               e.printStackTrace();
//           }
//        if (sheetName ==null)
//        {
//             sheet = wb.getSheetAt(0);
//        }else  {
//             sheet = wb.getSheet(sheetName);
//        }
//        row = sheet.getRow(0);
//       //标题总列数
//        int colNum = row.getPhysicalNumberOfCells();
//         int col=0;
//        boolean findCol=false;
//        while ( col<colNum) {
//        if ( getTitleValue(row.getCell((short) col)).trim().equals(cellContent))
//        {
//        findCol=true;
//        break;
//        }
//        col ++;
//        }
//        if (!findCol){ col=-1;}
//        return col;
//}
//
///**
//* 读取该单元格内容在第几列 xlsx
//* @param is
//* @param sheetName
//* @return
//*/
//private int readXlsxColIndexBycell(FileInputStream  is,String sheetName,String cellContent) {
//        try {
//              xwb = new XSSFWorkbook(is);
//             } catch (IOException e) {
//                e.printStackTrace();
//             }
//        if (sheetName ==null) {
//              xsheet = xwb.getSheetAt(0);
//        }else {
//              xsheet = xwb.getSheet(sheetName);
//        }
//        xrow = xsheet.getRow(0);
//        //标题总列数
//        int colNum = xrow.getPhysicalNumberOfCells();
//        int col=0;
//        boolean findCol=false;
//        while ( col<colNum) {
//                   if ( getTitleValue2(xrow.getCell((short) col)).trim().equals(cellContent))
//                      {
//                         findCol=true;
//                         break;
//                      }
//                   col ++;
//        }
//        if (!findCol){ col=-1;}
//              return col;
//}
//
//
//
//
///**
//*  xls  解析
//* @param o   //具体类
//* @param xtFields // excel 列名与表名对照
//* @param sheetName //sheet 名称
//* @param path   //路径
//* @param guidname // 名称
//* @param <T>
//* @return
//*/
//public <T> List<T> toDealXlsFile(Class<T> o , ExcelToTableField[] xtFields, String sheetName , String path, String guidname) throws FileNotFoundException, IllegalAccessException, InstantiationException {
//            File file = new File(path, guidname);
//            InputStream is=null;
//            is = new FileInputStream(file);
//            try {
//                fs = new POIFSFileSystem(is);
//            } catch (IOException e) {
//            // TODO Auto-generated catch block
//               e.printStackTrace();
//            }
//            try {
//                wb = new HSSFWorkbook(fs);
//            } catch (IOException e) {
//            // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
//
//           //读取指定sheet
//           sheet=wb.getSheet(sheetName);
//           ExcelReader excelReader = new ExcelReader();
//
//        //循环获取每行内容
//        int iExcelRow=1 ; //从第一行开始循环读数据
//        List<T> ret = new ArrayList<T>();
//       while (true)
//          {
//               T obj = o.newInstance();
//               row=sheet.getRow(iExcelRow ++);
//                if (getStringCellValue(row.getCell(0))==null || getStringCellValue(row.getCell(0)).equals(""))
//                {
//                    break;
//                }
//             //循环给出的列值对照, 为相应类赋值
//            for ( ExcelToTableField sf :xtFields) {
//                Field f = null;
//                try {
//                    f = o.getDeclaredField(sf.getTableFieldName());
//
//                } catch (NoSuchFieldException e) {
//                    e.printStackTrace();
//                }
//                f.setAccessible(true);//暴力反射，解除私有限定
//                try {
//                    //获取对应单元格值
//                    f.set(obj,  getStringCellValue(row.getCell(readXlsColIndexBycell(is,sheetName,sf.getExcelFieldName()))));
//                } catch (IllegalAccessException e) {
//                    e.printStackTrace();
//                }
//            }
//            ret.add( (T) obj);
//           }
//           return ret;
//}
//
//    /**
//     *  xlsx  解析
//     * @param o   //具体类
//     * @param xtFields // excel 列名与表名对照
//     * @param sheetName //sheet 名称
//     * @param path   //路径
//     * @param guidname // 名称
//     * @param <T>
//     * @return
//     */
//    public <T> List<T> toDealXlsxFile(Class<T> o , ExcelToTableField[] xtFields, String sheetName , String path, String guidname) throws FileNotFoundException, IllegalAccessException, InstantiationException {
//        File file = new File(path, guidname);
//        FileInputStream is=null;
//        is = new FileInputStream(file);
//
//        try {
//            xwb =  new XSSFWorkbook(is);
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//
//        //读取指定sheet
//        xsheet=xwb.getSheet(sheetName);
//        ExcelReader excelReader = new ExcelReader();
//
//        //循环获取每行内容
//        int iExcelRow=1 ; //从第一行开始循环读数据
//        List<T> ret = new ArrayList<T>();
//        while (true)
//        {
//            T obj = o.newInstance();
//
//            xrow=xsheet.getRow(iExcelRow ++);
//            if (getStringCellValue2(xrow.getCell(0))==null || getStringCellValue2(xrow.getCell(0)).equals(""))
//            {
//                break;
//            }
//            //循环给出的列值对照, 为相应类赋值
//            for ( ExcelToTableField sf :xtFields) {
//                Field f = null;
//                try {
//                    f = o.getDeclaredField(sf.getTableFieldName());
//
//                } catch (NoSuchFieldException e) {
//                    e.printStackTrace();
//                }
//                f.setAccessible(true);//暴力反射，解除私有限定
//                try {
//                    //获取对应单元格值
//                    f.set(obj,  getStringCellValue2(xrow.getCell(readXlsxColIndexBycell(is,sheetName,sf.getExcelFieldName()))));
//                } catch (IllegalAccessException e) {
//                    e.printStackTrace();
//                }
//            }
//            ret.add( (T) obj);
//        }
//        return ret;
//    }
//

}
