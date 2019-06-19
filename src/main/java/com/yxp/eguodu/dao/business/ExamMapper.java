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
            " #{examTime},'${examKindId}',${iyear},'${term}','${classesId}','${schoolId}',${totalScore})" +
            "</script>")
    public int insertExam(Exam exam);

    @Delete("<script>" +
            " delete from exam where examId='${examId}'" +
            "</script>")
    public int deleteExam(@Param("examId") String examId);

    @Insert("<script>" +
            "  insert into subexam(examId,studentId,subjectExamClassId,subjectExamNos,defficulty,score,getScore,subjects,rightSubjects,partSubjects) values" +
            " <foreach collection =\"list\" item=\"t\" separator =\",\" >" +
            " ( '${t.examId}','${t.studentId}','${t.subjectExamClassId}','${subjectExamNos}',${t.defficulty},${t.score},${t.getScore},${t.subjects},${t.rightSubjects},${t.partSubjects}) " +
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
public List<Map<String,Object>> currentStudentExamList(@Param("studentId") String studentId, @Param("pageBegin") String pageBegin , @Param("pageSize") String pageSize);


@Select("<script>" +
        " select exStus.examStudents , case when exStus.examStudents=0 then 0 else exAllScore.allScore/exStus.examStudents end as avgScore, " +
        "exMax.maxScore from   " +
        "( " +
        "select  examId , COUNT(DISTINCT studentid) as examStudents  from subexam where examid='${examId}' group by examId " +
        ") exStus inner join  " +
        "( " +
        "   select examId, SUM(getScore) as allScore from subexam  where examid='${examId}' group by examId " +
        ")exAllScore on exStus.examId=exAllScore.examId " +
        "inner join  " +
        "( " +
        "  select a.examId,max(a.scores) as maxScore from ( " +
        "   select examId , studentId, sum(getScore) as scores from subexam where examid='${examId}' group by examId, studentId " +
        "    ) a  group by a.examId " +
        ")exMax on exStus.examId=exMax.examId" +
        "</script>")
 public List<Map<String,Object>> classesExamScoreCensus(@Param("examId") String examId);


@Select("<script>" +
        " select  examId, studentId , score ,  getScore from v_studentexamscore where examId='${examId}'" +
        "</script>")
public List<Map<String,Object>> studentExamScoreList(@Param("examId") String examId);

@Select("<script>" +
        " select aa.defficulty,aa.subjects ,aa.rightSubjects ,aa.partSubjects ,aa.subjects-aa.rightSubjects-aa.partSubjects as wrongSubjects ,  " +
        "       ROUND( case when aa.subjects=0 then 0 else aa.rightSubjects/aa.subjects end ,4) as rightRate   " +
        " from (  " +
        " select defficulty, sum(subjects) as subjects , sum(rightSubjects) as rightSubjects,sum(partSubjects )  as partSubjects  from subexam where studentId='${studentId}' and examId='${examId}' and defficulty=1 group by defficulty  " +
        " union all  " +
        " select  defficulty, sum(subjects) as subjects , sum(rightSubjects) as rightSubjects ,sum(partSubjects )  as partSubjects   from subexam where studentId='${studentId}' and examId='${examId}' and defficulty=2 group by defficulty  " +
        " union all  " +
        " select  defficulty, sum(subjects) as subjects , sum(rightSubjects) as rightSubjects ,sum(partSubjects )  as partSubjects   from subexam where studentId='${studentId}' and examId='${examId}' and defficulty=3 group by defficulty  " +
        "  " +
        " )aa " +
        "</script>")
public List<Map<String,Object>> studentExamSubjectRate(@Param("studentId") String studentId , @Param("examId") String examId);


@Select("<script>" +
        "   " +
        "select m.subjectExamClassName,m.subjectExamNos ,m.totalScore,s.selfScore,   " +
        " case when t.totalstu=0 then 0 else a.avgScore/t.totalstu end as avgScore   " +
        " from   " +
        "(  " +
        "select e.examId, e.subjectExamClassId, e.subjectExamNos,  " +
        " c.subjectExamClassName, m.totalScore from subexam e   " +
        "inner join dic_subjectexamclass c on e.subjectExamClassId=c.subjectExamClassId  " +
        "inner join exam m on e.examId=m.examId   " +
        " where e.examId='${examId}'  " +
        ") m inner join (  " +
        "    SELECT examId , subjectExamClassId, sum(getScore) as selfScore from  subexam   " +
        "    where examId='${examId}' and  studentId='${studentId}'  " +
        "    group by examId , subjectExamClassId  " +
        ")s on m.examId=s.examId  and m.subjectExamClassId= s.subjectExamClassId inner join (  " +
        "  " +
        "  " +
        "      SELECT examId , subjectExamClassId, sum(getScore) as avgScore from  subexam   " +
        "      where examId='${examId}'   " +
        "      group by examId , subjectExamClassId  " +
        "  " +
        "  " +
        "  " +
        ")a on m.examId=a.examId  and m.subjectExamClassId= a.subjectExamClassId inner JOIN   " +
        "(  " +
        "   select examId, count(1) as totalstu from v_studentexamscore where examId='${examId}'  " +
        ")t  on m.examId=t.examId  " +
        "</script>")
public List<Map<String,Object>> studentExamRada(@Param("examId") String examId ,@Param("studentId") String studentId);

}
