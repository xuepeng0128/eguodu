package com.yxp.eguodu.dao.business;

import com.yxp.eguodu.entity.SchoolExamExcelTemplate;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface SchoolExamMapper {


    @Select("<script>" +
            "select stu.studentId ,stu.studentName  from  " +
            "( " +
            "  select studentId from classesstudent where endTime is null " +
            " )cs inner join student stu on cs.studentId=stu.studentId " +
            " where stu.endTime is not null and stu.schoolId='${schoolId}' " +
            " </script>")

    public List<SchoolExamExcelTemplate> prepareExamExcelTemp(Map<String,Object> paras);




}
