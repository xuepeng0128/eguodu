package com.yxp.eguodu.dao.basemsg;

import com.yxp.eguodu.common.queryparams.StudentQueryParams;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface StudentMapper {
    @Select("<script>" +
            " select paperId,studentName,tel,s.address,s.schoolId,c.schoolName,l.grade,l.classes,l.classesName\n" +
            " from student s inner join " +
            " school c on s.schoolId=c.schoolId inner JOIN classes l on s.schoolId=l.schoolId" +
            " </script>")
    public List<Map<String,Object>> studentList(StudentQueryParams queryParams);


}
