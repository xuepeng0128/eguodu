package com.yxp.eguodu.dao.dic;

import com.yxp.eguodu.entity.SubjectExamClass;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SubjectExamClassMapper {


    @Select("select subjectExamClassId ,subjectExamClassName,c.studySubjectId,b.studySubjectName from dic_subjectexamclass c " +
            " inner join dic_studysubject b on c.studySubjectId = b.studySubjectId ")
    public List<SubjectExamClass> subjectExamClassList();
    @Insert("<script>" +
            "  insert into dic_subjectexamclass(subjectExamClassId ,subjectExamClassName,studySubjectId) " +
            "  values (func_makeDicId('subjectexamclass',''),'${subjectExamClassName}','${studySubjectId}')" +
            "</script>")
    public int insertSubjectExamClass(SubjectExamClass SubjectExamClass);

    @Update("update dic_subjectexamclass set subjectExamClassName='${subjectExamClassName}',studySubjectId='${studySubjectId}' where subjectExamClassId='${subjectExamClassId}'")
    public int updateSubjectExamClass(SubjectExamClass SubjectExamClass);
    @Delete("<script>" +
            " delete from dic_subjectexamclass where subjectExamClassId='${subjectExamClassId}'" +
            "</script>")
    public int deleteSubjectExamClass(String subjectExamClassId);
    
    
    
    
}
