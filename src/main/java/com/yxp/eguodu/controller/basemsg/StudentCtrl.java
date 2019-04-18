package com.yxp.eguodu.controller.basemsg;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.yxp.eguodu.common.queryparams.StudentQueryParams;
import com.yxp.eguodu.common.queryparams.TeacherQueryParams;
import com.yxp.eguodu.entity.Teacher;
import com.yxp.eguodu.service.basemsg.StudentService;
import com.yxp.eguodu.service.basemsg.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/basemsg/student", method = {RequestMethod.GET, RequestMethod.POST}, produces = "application/json;charset=UTF-8")
public class StudentCtrl {

    @Autowired
    private StudentService svr;


    private String paperId;
    private String studentName;
    private String schoolId ;
    private String schoolName;
    private String pageSize;
    private String pageNo;
    private String pageBegin;


    @GetMapping(value="/studentList")
    public List<Map<String ,Object>> studentList(String studentId,String paperId, String studentName, String schoolId, String schoolName,
                                                  String pageSize, String pageNo, String pageBegin){
        StudentQueryParams queryParams=new StudentQueryParams( studentId, paperId,
                studentName,
                schoolId,
                schoolName,
                pageSize,
                pageNo,
                pageBegin);
        return svr.studentList(queryParams);
    }

//    @GetMapping(value="/studentListTotal")
//    public int studentListTotal( String paperId,
//                                 String studentName,
//                                 String schoolId,
//                                 String schoolName,
//                                 String studentDutyId,
//                                 String pageSize,
//                                 String pageNo,
//                                 String pageBegin){
//        StudentQueryParams queryParams=new StudentQueryParams(  paperId,
//                studentName,
//                schoolId,
//                schoolName,
//                studentDutyId,
//                pageSize,
//                pageNo,
//                pageBegin);
//        return Integer.parseInt( svr.studentList(queryParams).get(0).get("total").toString());
//    }
//
//    @GetMapping(value="/studentExcel")
//    public String studentExcel(String paperId,
//                               String studentName,
//                               String schoolId,
//                               String schoolName,
//                               String studentDutyId) throws UnsupportedEncodingException {
//        String filePath = "/export/" + RandomUtil.randomString(20).toUpperCase() + ".xls";
//        String tmpFile = URLDecoder.decode(ClassUtils.getDefaultClassLoader().getResource("").getPath(), "UTF-8") + "/static" + filePath;
//        ExcelWriter bigWriter = ExcelUtil.getBigWriter(tmpFile);
//        StudentQueryParams queryParams=new StudentQueryParams(  paperId,
//                studentName,
//                schoolId,
//                schoolName,
//                studentDutyId,
//                "5000",
//                "1",
//                "0");
//        List<Map<String,Object>> studentList = (List<Map<String,Object>>) svr.studentList(queryParams);
//        if (studentList.isEmpty())
//        {
//            return "nodata";
//        }else {
//            ArrayList<String> title = CollUtil.newArrayList("身份证", "姓名",  "联系电话","住址","当前职务", "所在学校");
//            List<List<String>> rows = CollUtil.newArrayList();
//            rows.add(title);
//            for (Map<String,Object> student : studentList) {
//                ArrayList<String> row = CollUtil.newArrayList(
//                        student.get("paperId").toString(),
//                        student.get("studentName").toString(),
//                        student.get("tel").toString(),
//                        student.get("address").toString(),
//                        student.get("studentDutyName").toString(),
//                        student.get("schoolName").toString()
//                );
//                rows.add(row);
//            }
//            try {
//                bigWriter.write(rows);
//            } catch (Exception e) {
//                e.printStackTrace();
//            } finally {
//                bigWriter.close();
//            }
//        }
//        return filePath;
//    }
//
//
//    @PostMapping(value="/insertStudent")
//    public String insertStudent(@RequestBody Student student){
//        int d = svr.insertStudent(student);
//        if (d>0)
//            return "ok";
//        else
//            return "fail";
//    }
//
//
//    @PostMapping(value = "/groupInsertStudents")
//    public String groupInsertStudents(@RequestBody List<Student> students){
//        int d = svr.groupInsertStudents(students);
//        if (d>0)
//            return "ok";
//        else
//            return "fail";
//    }
//
//
//    @PostMapping(value="/updateStudent")
//    public String updateStudent(@RequestBody Student student){
//        int d = svr.updateStudent(student);
//        if (d>0)
//            return "ok";
//        else
//            return "fail";
//    }
//
//    @GetMapping(value="/deleteStudent")
//    public String deleteStudent(String id){
//        int d = svr.deleteStudent(id);
//        if (d>0)
//            return "ok";
//        else
//            return "fail";
//    }
//
//




}
