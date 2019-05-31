package com.yxp.eguodu.service.business;

import com.yxp.eguodu.common.queryparams.TeacherArticleQueryParams;
import com.yxp.eguodu.entity.TeacherArticle;

import java.util.List;
import java.util.Map;

public interface TeacherArticleService {

    public List<Map<String,Object>> teacherArticleList(TeacherArticleQueryParams paras);

    public List<Map<String,Object>> teacherArticleListTotal(TeacherArticleQueryParams paras);

    public int insertArticle(TeacherArticle teacherArticle);

    public int updateArticle(TeacherArticle teacherArticle);

    public int publishArticle(Map<String,Object> paras);

    public int deleteArticle(Map<String,Object> paras);
    public int publishToHabit( String articleId,  String habitId);
}
