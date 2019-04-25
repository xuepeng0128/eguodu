package com.yxp.eguodu.controller.basemsg;

import cn.hutool.poi.excel.ExcelUtil;
import com.alibaba.fastjson.JSON;

import com.sun.org.apache.xerces.internal.xs.datatypes.ObjectList;
import com.yxp.eguodu.common.ExcelReader;
import com.yxp.eguodu.common.XlsRead;
import com.yxp.eguodu.entity.Teacher;
import com.yxp.eguodu.entity.excelTemp.TeacherExcel;
import com.yxp.eguodu.service.basemsg.TeacherService;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;

/**
 * 重点人员excel 导入处理类 extends XlsRead
 */
@CrossOrigin
@Controller
public class ImportantTeacherXlsRead extends XlsRead {

    @Autowired
    private TeacherService teacherService;

    @ResponseBody
    public void upload(@RequestParam MultipartFile file,@RequestParam String schoolId, HttpServletRequest request, HttpServletResponse response) throws IOException {
        String retstr = "";
        boolean insertflag=false;
      /*  retstr= JSON.toJSONString(this.GetUploadfile(file,request,response));*/
        Map<String, Object> resMap = new HashMap<String, Object>();
        resMap=this.GetUploadfile(file,request,response);
        if(resMap.get("status").equals("ok"))
        {
            String originFileName = file.getOriginalFilename().split("\\.")[1].toUpperCase();
            /////////////////读文件插数据库/////////////////////////////////////
             ExcelReader eread = new ExcelReader();
                try {
                    List<TeacherExcel> list = eread.toDealXlsFile(
                            TeacherExcel.class,
                            new TeacherExcel().getExcelTableFeilds(),
                            "教师",
                            this.path,this.guidname
                            );
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                }
                ////////////////////////////////////////////////////
                insertflag=dealXlsFile(this.path,this.guidname,this.tablename,"");
        }
        else {
            resMap.put("status","上传文件失败！");
            retstr=JSON.toJSONString(resMap);
        }
        PrintWriter writer = null;
        try {
            writer = response.getWriter();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        writer.print(retstr);
    }

    /**
     * 处理xls文件插入数据库
     */
    @Override
    public   boolean dealXlsFile(String path, String guidname, String tablename, String otherMsgJson) throws IOException {
        return true;
    }







    @PostMapping(value = "/importantTeacherXls/upload" , produces = "application/json;charset=UTF-8" )
    public void importDeviceData(@RequestBody MultipartFile file,String schoolId, HttpServletRequest request, HttpServletResponse response) {
        Map<String, String[]> parameterMap = request.getParameterMap();
            InputStream is = null;
            try {
                is = file.getInputStream();
            } catch (IOException e) {
                e.printStackTrace();
            }
            cn.hutool.poi.excel.ExcelReader reader = ExcelUtil.getReader(is);
            List<Teacher> tlist = new ArrayList<Teacher>();
            List<List<Object>> readAll = reader.read();
                for (List<Object> teachermList : readAll) {
                    if (teachermList.get(0).toString().contains("身份证") ) {
                        continue;
                    }
                    tlist.add( new Teacher(0,
                            teachermList.get(0).toString(), // 身份证
                            teachermList.get(1).toString(),// 电话
                            teachermList.get(2).toString(), // 老师姓名
                            "01", // 当前职务
                            "",
                            teachermList.get(3).toString() ,
                            schoolId,
                            null
                    ));
                }

        PrintWriter writer = null;
        try {
            writer = response.getWriter();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        writer.print(JSON.toJSONString(tlist));

    }




}
