package com.yxp.eguodu.service.business;

import com.yxp.eguodu.entity.TeacherArticle;

import java.util.List;
import java.util.Map;

public interface TeacherArticleService {

    public List<Map<String,Object>> teacherArticleList(Map<String,Object> paras);

    public List<Map<String,Object>> teacherArticleListTotal(Map<String,Object> paras);

    public int insertArticle(TeacherArticle teacherArticle);

    public int updateArticle(TeacherArticle teacherArticle);

    public int publishArticle(Map<String,Object> paras);

    public int deleteArticle(Map<String,Object> paras);
}
