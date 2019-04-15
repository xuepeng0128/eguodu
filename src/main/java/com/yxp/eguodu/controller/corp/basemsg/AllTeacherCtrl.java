package com.yxp.eguodu.controller.corp.basemsg;


import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.yxp.stuhabit.entity.School;
import com.yxp.stuhabit.entity.Teacher;
import com.yxp.stuhabit.entity.TeacherDuty;
import com.yxp.stuhabit.entity.TeacherOnserve;
import com.yxp.stuhabit.service.basemsg.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/corp/basemsg/teacher", method = {RequestMethod.GET, RequestMethod.POST}, produces = "application/json;charset=UTF-8")
public class AllTeacherCtrl {
    @Autowired
    private TeacherService svr;

    @GetMapping(value="/teacherList")
    public Map<String ,Object> teacherList(String paperId,String teacherName,String schoolId , String schoolName,String duty,String pageSize,String pageNo,String getTotal){
          return svr.teacherList(paperId,teacherName,schoolId, schoolName,duty,pageSize,pageNo,getTotal);
    }

    @GetMapping(value="/singleTeacher")
    public Teacher singleTeacher(String paperId){
        return svr.singleTeacher(paperId);
    }



    @GetMapping(value="/teacherExcel")
    public String teacherExcel(String paperId,String teacherName,String schoolId,String schoolName,String duty,String pageSize,String pageNo,String getTotal) throws UnsupportedEncodingException {
        String filePath = "/export/" + RandomUtil.randomString(20).toUpperCase() + ".xls";
        String tmpFile = URLDecoder.decode(ClassUtils.getDefaultClassLoader().getResource("").getPath(), "UTF-8") + "/static" + filePath;
        ExcelWriter bigWriter = ExcelUtil.getBigWriter(tmpFile);

        List<Teacher> teacherList = (List<Teacher>) svr.teacherList(paperId,teacherName,schoolId,schoolName,duty,"5000","1","0").get("list");
        if (teacherList.isEmpty())
        {
            return "nodata";
        }else {
            ArrayList<String> title = CollUtil.newArrayList("身份证", "姓名", "当前职务", "联系电话", "所在学校");
            List<List<String>> rows = CollUtil.newArrayList();
            rows.add(title);
            for (Teacher teacher : teacherList) {
                ArrayList<String> row = CollUtil.newArrayList(
                        teacher.getPaperId(),
                        teacher.getTeacherName(),
                        Optional.ofNullable(teacher.getTeacherDuty()).orElse(new TeacherDuty()).getTeacherDutyName(),
                        teacher.getTel(),
                        Optional.ofNullable(
                              Optional.ofNullable(teacher.getOnserve()).orElse(new TeacherOnserve()).getSchool()
                        ).orElse(new School()).getSchoolName()
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

}
