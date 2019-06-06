package com.yxp.eguodu.dao.business;

import com.yxp.eguodu.common.queryparams.TeacherNoticeParams;
import com.yxp.eguodu.entity.Notice;
import com.yxp.eguodu.entity.NoticeStudent;
import com.yxp.eguodu.entity.TeacherNotice;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

@Mapper
public interface TeacherNoticeMapper {
    @Select("<script>" +
            " select tn.teacherNoticeId,tn.buildDate,tn.memo,tn.sendCircleIds,c.circleTitle as sendCircleTitles , tn.buildTeacherId , t.teacherName as buildTeacherName " +
            " from teachernotice tn inner join teacher t on tn.buildTeacherId=t.teacherId  and tn.schoolId=t.schoolId " +
            " inner join circle c on tn.sendCircleIds=c.circleId " +
            " where tn.buildTeacherId='${buildTeacherId}' and tn.schoolId='${schoolId}' " +
            "  LIMIT ${pageBegin},${pageSize} " +
            "</script>")
    public List<TeacherNotice> teacherNoticeList(TeacherNoticeParams teacherNoticeParams);



    @Select("<script>" +
            " select count(*) as total " +
            " from teachernotice tn inner join teacher t on tn.buildTeacherId=t.teacherId  and tn.schoolId=t.schoolId " +
            " inner join circle c on tn.sendCircleIds=c.circleId " +
            " where tn.buildTeacherId='${buildTeacherId}' and tn.schoolId='${schoolId}' " +
            "</script>")
    public List<Map<String,Object>> teacherNoticeListTotal(TeacherNoticeParams teacherNoticeParams);



    @Insert("<script> " +
            " insert into teachernotice(teacherNoticeId, buildDate,memo,sendCircleIds,buildTeacherId,schoolId) " +
            " values(#{teacherNoticeId}, now(),#{memo},#{sendCircleIds},#{buildTeacherId},#{schoolId}) " +
            " </script>")
    public int insertTeacherNotice(TeacherNotice teacherNotice);


}
