package com.yxp.eguodu.service.basemsg;

import com.yxp.eguodu.common.queryparams.ClassesQueryParams;

import java.util.List;
import java.util.Map;

public interface ClassesService {
    public List<Map<String,Object>> classesList(ClassesQueryParams params);
    public List<Map<String,Object>> classesListTotal(ClassesQueryParams params);
}
