package com.yxp.eguodu.dao.dic;

import com.yxp.eguodu.entity.StudySubject;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudySubjectMapper {

    @Select("select studySubjectId ,studySubjectName,habitClass from dic_studysubject")
    public List<StudySubject> studySubjectList();
    @Insert("<script>" +
            "  insert into dic_studysubject(studySubjectId ,studySubjectName,habitClass) " +
            "  values (func_makeDicId('studysubject',''),'${studySubjectName}',${habitClass})" +
            "</script>")
    public int insertStudySubject(StudySubject studySubject);

    @Update("<script>" +
            "update dic_studysubject set studySubjectName='${studySubjectName}',habitClass=${habitClass} " +
            "where studySubjectId='${studySubjectId}'" +
            "</script>")
    public int updateStudySubject(StudySubject studySubject);
    @Delete("<script>" +
            " delete from dic_studysubject where studySubjectId='${studySubjectId}'" +
            "</script>")
    public int deleteStudySubject(String studySubjectId);
    
    
}
