package com.yxp.eguodu.dao.business;

import com.yxp.eguodu.entity.Notice;
import com.yxp.eguodu.entity.NoticeStudent;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

@Mapper
public interface NoticeMapper {

    @Select("<script>" +
            "select m.noticeId,m.noticeContent, ifnull(count(1),0)  as receiveStudentNums  from notice m inner join " +
            "noticestudent s on m.noticeId=s.noticeId " +
            "where m.teacherId='${teacherId}' " +
            " <if test='noticeContent != null and noticeContent !=\"\"'>" +
            "and m.noticeContent like '%${noticeContent}%' " +
            " </if> " +
            "group by m.noticeId,m.noticeContent " +
            "LIMIT ${pageBegin},${pageSize} " +
            "</script>")
    public List<Notice> noticeList(Map<String,Object> paras);

    @Select("<script>" +
            "  select nt.noticeId,nt.studentId,s.studentName, nt.receiveTime from noticestudent nt inner join " +
            "  student s on nt.studentId=s.studentId and s.schoolId='${schoolId}' " +
            " where nt.noticeId='${noticeId}' " +
            "</script>")
    public List<NoticeStudent> noticeStudentList(Map<String,Object> paras);

    @Insert("insert into notice(noticeId,noticeContent,teacherId,sendTime) " +
            " values(#{noticeId},#{noticeContent},#{teacherId},now())")
   public int insertNotice(Notice notice);

    @Insert(" <script>" +
            "   insert into noticestudent(noticeId,studentId ) values " +
            "  <foreach collection =\"list\" item=\"t\" separator =\",\" > " +
            "       (#{t.noticeId},#{t.studentId}) " +
            " </foreach> " +
            " </script>")
    public int insertNoticeStudent(List<NoticeStudent> noticeStudents);

    @Update("<script> update noticestudent set receivetime = now() where noticeId='${noticeId}' and studentId ='${studentId}' </script> ")
    public int noticeStudentReceived(Map<String,Object> params);


}
