package com.yxp.eguodu.dao.dic;

import com.yxp.eguodu.entity.StudySubject;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudySubjectMapper {

    @Select("select s.studySubjectId ,s.studySubjectName,s.habitClassId,h.habitClassName,s.subHabitClassId,sh.habitClassName as subHabitClassName," +
            " primarySchool,middleSchool from dic_studysubject s " +
            " inner join dic_habitclass h on s.habitClassId=h.habitClassId inner join dic_habitclass sh on s.subHabitClassId= sh.habitClassId ")
    public List<StudySubject> studySubjectList();
    @Insert("<script>" +
            "  insert into dic_studysubject(studySubjectId ,studySubjectName,habitClassId,subHabitClassId,primarySchool,middleSchool) " +
            "  values (func_makeDicId('studysubject',''),#{studySubjectName},#{habitClassId},#{subHabitClassId},#{primarySchool},#{middleSchool})" +
            "</script>")
    public int insertStudySubject(StudySubject studySubject);

    @Update("<script>" +
            "update dic_studysubject set studySubjectName=#{studySubjectName},habitClassId=#{habitClassId} ,subHabitClassId=#{subHabitClassId}," +
            " primarySchool=#{primarySchool},middleSchool=#{middleSchool} " +
            "where studySubjectId=#{studySubjectId}" +
            "</script>")
    public int updateStudySubject(StudySubject studySubject);
    @Delete("<script>" +
            " delete from dic_studysubject where studySubjectId='${studySubjectId}'" +
            "</script>")
    public int deleteStudySubject(String studySubjectId);
    
    
}
