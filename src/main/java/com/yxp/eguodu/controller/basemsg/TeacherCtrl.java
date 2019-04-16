package com.yxp.eguodu.controller.basemsg;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.yxp.eguodu.common.queryparams.TeacherQueryParams;
import com.yxp.eguodu.entity.Teacher;
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
@RequestMapping(value = "/api/basemsg/teacher", method = {RequestMethod.GET, RequestMethod.POST}, produces = "application/json;charset=UTF-8")

public class TeacherCtrl {

    @Autowired
    private TeacherService svr;

    @GetMapping(value="/teacherList")
    public List<Map<String ,Object>> teacherList( String paperId,
                                            String teacherName,
                                            String schoolId,
                                            String schoolName,
                                            String teacherDutyId,
                                            String pageSize,
                                            String pageNo,
                                            String pageBegin){
        TeacherQueryParams queryParams=new TeacherQueryParams(  paperId,
         teacherName,
          schoolId,
          schoolName,
          teacherDutyId,
          pageSize,
          pageNo,
          pageBegin);
        return svr.teacherList(queryParams);
    }

    @GetMapping(value="/teacherListTotal")
    public int teacherListTotal( String paperId,
                                            String teacherName,
                                            String schoolId,
                                            String schoolName,
                                            String teacherDutyId,
                                            String pageSize,
                                            String pageNo,
                                            String pageBegin){
        TeacherQueryParams queryParams=new TeacherQueryParams(  paperId,
                teacherName,
                schoolId,
                schoolName,
                teacherDutyId,
                pageSize,
                pageNo,
                pageBegin);
        return Integer.parseInt( svr.teacherList(queryParams).get(0).get("total").toString());
    }

    @GetMapping(value="/teacherExcel")
    public String teacherExcel(String paperId,
                               String teacherName,
                               String schoolId,
                               String schoolName,
                               String teacherDutyId) throws UnsupportedEncodingException {
        String filePath = "/export/" + RandomUtil.randomString(20).toUpperCase() + ".xls";
        String tmpFile = URLDecoder.decode(ClassUtils.getDefaultClassLoader().getResource("").getPath(), "UTF-8") + "/static" + filePath;
        ExcelWriter bigWriter = ExcelUtil.getBigWriter(tmpFile);
        TeacherQueryParams queryParams=new TeacherQueryParams(  paperId,
                teacherName,
                schoolId,
                schoolName,
                teacherDutyId,
                "5000",
                "1",
                "0");
        List<Map<String,Object>> teacherList = (List<Map<String,Object>>) svr.teacherList(queryParams);
        if (teacherList.isEmpty())
        {
            return "nodata";
        }else {
            ArrayList<String> title = CollUtil.newArrayList("身份证", "姓名",  "联系电话","住址","当前职务", "所在学校");
            List<List<String>> rows = CollUtil.newArrayList();
            rows.add(title);
            for (Map<String,Object> teacher : teacherList) {
                ArrayList<String> row = CollUtil.newArrayList(
                        teacher.get("paperId").toString(),
                        teacher.get("teacherName").toString(),
                        teacher.get("tel").toString(),
                        teacher.get("address").toString(),
                        teacher.get("teacherDutyName").toString(),
                        teacher.get("schoolName").toString()
                );
                rows.add(row);
            }
            try {
                bigWriter.write(rows);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                bigWriter.close();
            }
        }
        return filePath;
    }


    @PostMapping(value="/insertTeacher")
    public String insertTeacher(@RequestBody Teacher teacher){
        int d = svr.insertTeacher(teacher);
        if (d>0)
            return "ok";
        else
            return "fail";
    }


    @PostMapping(value = "/groupInsertTeachers")
    public String groupInsertTeachers(@RequestBody List<Teacher> teachers){
        int d = svr.groupInsertTeachers(teachers);
        if (d>0)
            return "ok";
        else
            return "fail";
    }


    @PostMapping(value="/updateTeacher")
    public String updateTeacher(@RequestBody Teacher teacher){
        int d = svr.updateTeacher(teacher);
        if (d>0)
            return "ok";
        else
            return "fail";
    }

    @GetMapping(value="/deleteTeacher")
    public String deleteTeacher(String id){
        int d = svr.deleteTeacher(id);
        if (d>0)
            return "ok";
        else
            return "fail";
    }







}
