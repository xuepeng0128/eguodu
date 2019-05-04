package com.yxp.eguodu.service.basemsg;

import com.yxp.eguodu.common.queryparams.ClassesQueryParams;
import com.yxp.eguodu.entity.Classes;

import java.util.List;
import java.util.Map;

public interface ClassesService {
    public List<Map<String,Object>> classesList(ClassesQueryParams params);
    public List<Map<String,Object>> classesListTotal(ClassesQueryParams params);

    public int insertClasses(Classes classes);
    public int updateClasses(Classes classes);
    public int deleteClasses(Map<String,Object> paras);
}
