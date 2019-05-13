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
            " select main.noticeId,main.noticeContent,main.receiveStudentNums , ifnull(sub.haveReadStudentNums,0) as haveReadStudentNums from  " +
            " " +
            "  (select m.noticeId,m.noticeContent, ifnull(count(1),0)  as receiveStudentNums  from notice m inner join \n" +
            "         noticestudent s on m.noticeId=s.noticeId  " +
            "          where m.teacherId='${teacherId}'  " +
            "      and m.noticeContent like '%${noticeContent}%'  " +
            "     group by m.noticeId,m.noticeContent " +
            ") main left outer join  " +
            "  ( " +
            "   select m.noticeId,ifnull(count(1),0)  as haveReadStudentNums  from notice m inner join  " +
            "         noticestudent s on m.noticeId=s.noticeId  " +
            "          where m.teacherId='${teacherId}' and s.receivetime is not null " +
            "      and m.noticeContent like '%${noticeContent}%'  " +
            "     group by m.noticeId) sub on main.noticeId=sub.noticeId " +
            "  LIMIT ${pageBegin},${pageSize} " +
            "</script>")
    public List<Notice> noticeList(Map<String,Object> paras);



    @Select("<script>" +
            " select count(*) as total from (" +
            "     select main.noticeId,main.noticeContent,main.receiveStudentNums , ifnull(sub.haveReadStudentNums,0) as haveReadStudentNums from  " +

            "        (select m.noticeId,m.noticeContent, ifnull(count(1),0)  as receiveStudentNums  from notice m inner join " +
            "                noticestudent s on m.noticeId=s.noticeId  " +
            "                    where m.teacherId='${teacherId}'  " +
            "                 and m.noticeContent like '%${noticeContent}%'  " +
            "               group by m.noticeId,m.noticeContent " +
            "         ) main left outer join  " +
            "           ( " +
            "             select m.noticeId,ifnull(count(1),0)  as haveReadStudentNums  from notice m inner join  " +
            "                 noticestudent s on m.noticeId=s.noticeId  " +
            "                    where m.teacherId='${teacherId}' and s.receivetime is not null " +
            "                and m.noticeContent like '%${noticeContent}%'  " +
            "               group by m.noticeId) sub on main.noticeId=sub.noticeId" +
            " ) a " +
            "</script>")
    public List<Map<String,Object>> noticeListTotal(Map<String,Object> paras);


    @Select("<script>" +
            "  select nt.noticeId,nt.studentId,s.studentName, nt.receiveTime from noticestudent nt inner join " +
            "  student s on nt.studentId=s.studentId and s.schoolId='${schoolId}' " +
            " where nt.noticeId='${noticeId}' " +
            "</script>")
    public List<NoticeStudent> noticeStudentList(Map<String,Object> paras);

    @Insert("<script> insert into notice(noticeId,noticeContent,teacherId,sendTime) " +
            " values(#{noticeId},#{noticeContent},#{teacherId},now()) </script>")
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
