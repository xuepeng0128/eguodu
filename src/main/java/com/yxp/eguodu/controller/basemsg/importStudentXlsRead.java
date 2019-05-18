package com.yxp.eguodu.controller.basemsg;

import cn.hutool.poi.excel.ExcelUtil;
import com.alibaba.fastjson.JSON;
import com.yxp.eguodu.common.XlsRead;
import com.yxp.eguodu.entity.Student;
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
import java.util.Date;
import java.util.List;
import java.util.Map;

@CrossOrigin
@Controller
public class importStudentXlsRead  extends XlsRead {

//学号	身份证	联系电话	名称	性别	出生日期	家庭住址
    @PostMapping(value = "/importantStudentXls/upload" , produces = "application/json;charset=UTF-8" )
    public void importStudentData(@RequestBody MultipartFile file, String schoolId, HttpServletRequest request, HttpServletResponse response) {
        Map<String, String[]> parameterMap = request.getParameterMap();
        InputStream is = null;
        try {
            is = file.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        cn.hutool.poi.excel.ExcelReader reader = ExcelUtil.getReader(is);
        List<Student> tlist = new ArrayList<Student>();
        List<List<Object>> readAll = reader.read();
        for (List<Object> studentmList : readAll) {
            if (studentmList.get(0).toString().contains("学号") ) {
                continue;
            }

            tlist.add( new Student( 0 ,    studentmList.get(1).toString(), // 身份证
                    studentmList.get(0).toString() ,
                    studentmList.get(3).toString() ,
                    Integer.parseInt(studentmList.get(4).toString().equals("男") ? "1" :"2"), // 性别
                    (Date)  studentmList.get(5),// 出生日期
                    schoolId,
                    studentmList.get(6).toString(), // 老师姓名
                    studentmList.get(2).toString(), // 老师姓名
                     null,null,null,null
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
