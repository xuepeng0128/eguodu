package com.yxp.eguodu.controller.basemsg;

import cn.hutool.poi.excel.ExcelUtil;
import com.alibaba.fastjson.JSON;
import com.yxp.eguodu.common.XlsRead;
import com.yxp.eguodu.entity.Teacher;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@CrossOrigin
@Controller
public class importStudentXlsRead  extends XlsRead {


    @PostMapping(value = "/importantTeacherXls/upload" , produces = "application/json;charset=UTF-8" )
    public void importDeviceData(@RequestBody MultipartFile file, String schoolId, HttpServletRequest request, HttpServletResponse response) {
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
            tlist.add( new Teacher("",
                    teachermList.get(0).toString(), // 身份证
                    teachermList.get(1).toString(),// 电话
                    teachermList.get(2).toString(), // 老师姓名
                    "01", // 当前职务
                    "",
                    false,
                    teachermList.get(3).toString() ,
                    schoolId,
                    null
            ));
        }
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = null;
        try {
            writer = response.getWriter();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        writer.print(JSON.toJSONString(tlist));

    }


    @Override
    public boolean dealXlsFile(String path, String guidname, String tablename, String otherMsgJson) throws IOException {
        return true;
    }
}
