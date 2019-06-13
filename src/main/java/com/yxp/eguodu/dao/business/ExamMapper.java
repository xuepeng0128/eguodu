package com.yxp.eguodu.dao.business;

import com.yxp.eguodu.common.queryparams.ExamQueryParams;
import com.yxp.eguodu.entity.Exam;
import com.yxp.eguodu.entity.SubExam;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface ExamMapper {

    @Select("<script>" +
            " select ex.examId, ex.studySubjectId, ss.studySubjectName,  ex.examName,ex.teachedTeacherId,  " +
            "       t.teacherName as teachedTeacherName,ex.examTime,ex.examKindId , ek.examKindName, ex.iyear ,  " +
            "       ex.term,ex.classesId , " +
            "       cl.grade ,cl.classes ,ex.SchoolId ,ex.totalScore from exam ex inner join dic_studysubject ss  " +
            "      on ex.studySubjectId=ss.studySubjectId inner join teacher t on ex.teachedTeacherId=t.teacherId " +
            "      INNER JOIN dic_examkind ek on ex.examKindId=ek.examKindid inner join classes cl on ex.classesId=cl.classesId " +
            " where 1=1  " +
            " <if test='classesIds != null and classesIds !=\"\"'>" +
            "   and ex.classesId in (${classesIds}) " +
            " </if> " +
            "   and ex.schoolId ='${schoolId}'" +
            "  limit ${pageBegin}, ${pageSize} " +
            "</script>")
   public List<Exam> examList(ExamQueryParams examQueryParams);

    @Select("<script>" +
            " select count(*) as total  from exam ex inner join dic_studysubject ss  " +
            "      on ex.studySubjectId=ss.studySubjectId inner join teacher t on ex.teachedTeacherId=t.teacherId " +
            "      INNER JOIN dic_examkind ek on ex.examKindId=ek.examKindid inner join classes cl on ex.classesId=cl.classesId " +
            " where 1=1  " +
            " <if test='classesIds != null and classesIds !=\"\"'>" +
            "   and ex.classesId in( ${classesIds}) " +
            " </if> " +
            "   and ex.schoolId ='${schoolId}'" +
            "</script>")
    public List<Map<String,Object>> examListTotal(ExamQueryParams examQueryParams) ;


    @Select("<script>" +
            " select e.id, e.examId,e.studentId, stu.studentName , e.subjectExamClassId,ec.subjectExamClassName,e.defficulty," +
            "  e.score,e.getScore,e.subjects,e.rightSubjects from " +
            "  subexam e inner join exam m on e.examId=m.examId inner join student stu on e.studentId=stu.studentId " +
            " and m.schoolId=stu.schoolId  inner join dic_subjectexamclass ec on e.subjectExamClassId= ec.subjectExamClassId " +
            "  where e.examId='${examId}'" +
            "  order by e.studentId,e.subjectExamClassId,e.defficulty" +
            "</script>")
   public List<SubExam> subExamList(@Param("examId") String examId);


    @Select("<script>" +
            "SELECT 0 as id,'' as examId, stu.studentId,stu.studentName,sub.subjectExamClassId, " +
            "       sub.subjectExamClassName,de.defficulty, 0 as score,0 as getScore,0 as subjects , 0 as rightSubjects from  " +
            "( " +
            "select s.studentId,s.studentName from classesstudent c inner join student s " +
            " on c.studentId=s.studentId and s.schoolId='${schoolId}'  where classesId='${classesId}' " +
            ")stu CROSS join " +
            "( " +
            "   select subjectExamClassId, subjectExamClassName from dic_subjectexamclass   where studySubjectId='${studySubjectId}' " +
            ") sub cross join ( " +
            "  SELECT 1 as defficulty " +
            "  union all  " +
            "  select 2 as defficulty " +
            "  union ALL " +
            "   select 3 as defficulty " +
            " )de  " +
            " order by stu.studentId,sub.subjectExamClassId,de.defficulty " +
            "</script>")
    public List<SubExam> initSubExamList(@Param("schoolId") String schoolId,@Param("classesId") String classesId, @Param("studySubjectId") String studySubjectId);



    @Insert("<script>" +
            " insert into exam(examId,studySubjectId,examName,teachedTeacherId, " +
            " examTime,examKindId,iyear,term,classesId,schoolId,totalScore) values('${examId}','${studySubjectId}','${examName}','${teachedTeacherId}'," +
            " '${examTime}','${examKindId}',${iyear},'${term}','${classesId}','${schoolId}',${totalScore})" +
            "</script>")
    public int insertExam(Exam exam);

    @Delete("<script>" +
            " delete from exam where examId='${examId}'" +
            "</script>")
    public int deleteExam(@Param("examId") String examId);

    @Insert("<script>" +
            "  insert into subexam(examId,studentId,subjectExamClassId,defficulty,score,getScore,subjects,rightSubjects) values" +
            " <foreach collection =\"list\" item=\"t\" separator =\",\" >" +
            " ( '${t.examId}','${t.studentId}','${t.subjectExamClassId}',${t.defficulty},${t.score},${t.getScore},${t.subjects},${t.rightSubjects}) " +
            "</foreach>" +
            "</script>")
    public int insertSubExam(List<SubExam> subExams);


    @Delete("<script>" +
            " delete from subexam where examId='${examId}'" +
            "</script>")
    public int deleteSubExam(@Param("examId") String examId);




    //-------------------------------------- 微信-----------------------------------//
@Select("<script>" +
        "    select ex.examId, ex.studySubjectId, ss.studySubjectName,  ex.examName,ex.teachedTeacherId,   " +
        "                   t.teacherName as teachedTeacherName,ex.examTime,ex.examKindId , ek.examKindName, ex.iyear ,   " +
        "                   ex.term,ex.classesId ,  " +
        "                   cl.grade ,cl.classes ,ex.SchoolId ,ex.totalScore ,sbx.getScore from exam ex inner join dic_studysubject ss   " +
        "                  on ex.studySubjectId=ss.studySubjectId inner join teacher t on ex.teachedTeacherId=t.teacherId  " +
        "                  INNER JOIN dic_examkind ek on ex.examKindId=ek.examKindid inner join classes cl" +
        "                   on ex.classesId=cl.classesId  " +
        "                  inner join classesstudent cs on cl.classesId=cs.classesId and studentId='${studentId}'" +
        "                  inner join " +
        "                  (" +
        "                       select examId, studentId ,sum(getScore) as getScore from subexam where studentId='${studentId}' group by examId, studentId" +
        "                  )sbx on  ex.examId=sbx.examId" +
        "                   " +
        "        order by  ex.examTime desc " +
        "   limit ${pageBegin},${pageSize} " +
        "</script>")
public List<Map<String,Object>> currentStudentExamList(@Param("studentId") String studentId);


@Select("<script>" +
        "</script>")
 public List<Map<String,Object>> classesExamScoreCensus(@Param("studentId") String studentId,@Param("examId") String examId);

}
