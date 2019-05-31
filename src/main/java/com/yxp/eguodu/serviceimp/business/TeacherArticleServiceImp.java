package com.yxp.eguodu.serviceimp.business;

import com.sun.org.apache.xerces.internal.xs.datatypes.ObjectList;
import com.yxp.eguodu.common.queryparams.TeacherArticleQueryParams;
import com.yxp.eguodu.dao.business.TeacherArticleMapper;
import com.yxp.eguodu.entity.TeacherArticle;
import com.yxp.eguodu.service.business.TeacherArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TeacherArticleServiceImp implements TeacherArticleService {
    @Autowired
    private TeacherArticleMapper mapper;

    @Override
    public List<Map<String, Object>> teacherArticleList(TeacherArticleQueryParams paras) {
        List<Map<String, Object>> list =mapper.teacherArticleList(paras);
        return list;
    }

    @Override
    public List<Map<String, Object>> teacherArticleListTotal(TeacherArticleQueryParams paras) {
        List<Map<String, Object>> list =mapper.teacherArticleListTotal(paras);
        return list;
    }

    @Override
    public int insertArticle(TeacherArticle teacherArticle) {
        return mapper.insertArticle(teacherArticle);
    }

    @Override
    public int updateArticle(TeacherArticle teacherArticle) {
        return mapper.updateArticle(teacherArticle);
    }

    @Override
    public int publishArticle(Map<String, Object> paras) {
        mapper.delPublicArticleHabit(paras);
        mapper.publishArticle(paras);
        mapper.publishArticleHabit( (List<Map<String,Object>>) paras.get("habitlist"));
        return 1;
    }

    @Override
    public int deleteArticle(Map<String, Object> paras) {
        return mapper.deleteArticle(paras);
    }

    @Override
    public int publishToHabit(String articleId, String habitId) {
        return mapper.publishToHabit(articleId,habitId);
    }
}
