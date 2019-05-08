package com.yxp.eguodu.dao.business;

import com.yxp.eguodu.entity.TeacherArticle;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface TeacherArticleMapper {

    @Select("<script>" +
            " select tr.articleId, " +
            "       tr.articleTitle, " +
            "       tr.makeDate, " +
            "       tr.teacherId, " +
            "       t.teacherName, " +
            "       tr.schoolId, " +
            "       s.schoolName,  " +
            "       tr.articleContent, " +
            "       tr.published, " +
            "       ifnull(ta.habitNum,0) as habitNum " +
            "from teacherarticle tr inner join school s on tr.schoolId=s.schoolId   " +
            "inner join teacher t  on tr.teacherId=t.teacherId  " +
            "left outer join ( " +
            "  select articleId, ifnull(count(1),0) as habitNum from teacherarticlehabit " +
            "  group by articleId " +
            ")ta on tr.articleId=ta.articleId  " +
            "where 1=1 " +
            " <if test='teacherId !=null and teacherId !=\"\"'> " +
            "   and tr.teacherId='${teacherId}'" +
            " </if> " +
            " <if test='teacherName !=null and teacherName !=\"\"'> " +
            "   and t.teacherName like '%${teacherName}%'" +
            " </if> " +
            " <if test='schoolId !=null and schoolId !=\"\"'> " +
            "   and tr.schoolId = '${schoolId}'" +
            " </if> " +
            " <if test='schoolName !=null and schoolName !=\"\"'> " +
            "   and s.schoolName like '%${schoolName}%'" +
            " </if> " +
            " limit ${pageBegin},${pageSize}" +
            "</script>")
    public List<Map<String,Object>> teacherArticleList(Map<String,Object> paras);


    @Select("<script>" +
            " select count(*) as total " +
            "from teacherarticle tr inner join school s on tr.schoolId=s.schoolId   " +
            "inner join teacher t  on tr.teacherId=t.teacherId  " +
            "left outer join ( " +
            "  select articleId, ifnull(count(1),0) as habitNum from teacherarticlehabit " +
            "  group by articleId " +
            ")ta on tr.articleId=ta.articleId  " +
            "where 1=1 " +
            " <if test='teacherId !=null and teacherId !=\"\"'> " +
            "   and tr.teacherId='${teacherId}'" +
            " </if> " +
            " <if test='teacherName !=null and teacherName !=\"\"'> " +
            "   and t.teacherName like '%${teacherName}%'" +
            " </if> " +
            " <if test='schoolId !=null and schoolId !=\"\"'> " +
            "   and tr.schoolId = '${schoolId}'" +
            " </if> " +
            " <if test='schoolName !=null and schoolName !=\"\"'> " +
            "   and s.schoolName like '%${schoolName}%'" +
            " </if> " +
            "</script>")
    public List<Map<String,Object>> teacherArticleListTotal(Map<String,Object> paras);



    @Insert(" <script> insert teacherarticle(articleId,articleTitle,makeDate,teacherId,schoolId,articleContent,published) " +
            " values( func_makeBusinessId('article',#{schoolId}),#{articleTitle},now(),#{teacherId},#{schoolId}," +
            "#{articleContent},#{published})" +
            " </script>")
    public int insertArticle(TeacherArticle teacherArticle);

    @Update(" <script> update teacherarticle set articleTitle=#{articleTitle},articleContent =#{articleContent} " +
            "where articleId=#{articleId}" +
            " </script>")
    public int updateArticle(TeacherArticle teacherArticle);

    @Update(" <script> update teacherarticle set published=true where articleId=#{articleId} </script>")
    public int publishArticle(Map<String,Object> paras);

    @Insert(" <script> insert into teacherarticlehabit(circleHabitId,articleId) values " +
            " <foreach collection =\"list\" item=\"t\" separator =\",\" >" +
            " ( '${t.circleHabitId}','${t.articleId}') " +
            "</foreach>" +
            " </script>")
    public int publishArticleHabit(List<Map<String,Object>> paras);

    @Delete(" <script> delete from teacherarticlehabit where articleId=#{articleId} </script>")
    public int delPublicArticleHabit(Map<String,Object> paras);



    @Delete("<script> delete from teacherarticle where articleId=#{articleId} </script>")
    public int deleteArticle(Map<String,Object> paras);

}
