package com.yxp.eguodu.serviceimp.basemsg;

import com.yxp.eguodu.common.queryparams.ClassesQueryParams;
import com.yxp.eguodu.dao.basemsg.ClassesMapper;
import com.yxp.eguodu.entity.Classes;
import com.yxp.eguodu.service.basemsg.ClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ClassesServiceImp implements ClassesService {
    @Autowired
    private ClassesMapper classesMapper;
    @Override
    public List<Map<String, Object>> classesList(ClassesQueryParams params) {
        return classesMapper.classesList(params);
    }

    @Override
    public List<Map<String, Object>> classesListTotal(ClassesQueryParams params) {
        return classesMapper.classesListTotal(params);
    }

    @Override
    public int insertClasses(Classes classes) {
        return classesMapper.insertClasses(classes);
    }

    @Override
    public int updateClasses(Classes classes) {
        return classesMapper.updateClasses(classes);
    }

    @Override
    public int deleteClasses(Map<String,Object> paras) {
        return classesMapper.deleteClasses(paras);
    }
}
