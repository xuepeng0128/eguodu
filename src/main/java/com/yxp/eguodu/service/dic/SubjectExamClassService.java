package com.yxp.eguodu.service.dic;

import com.yxp.eguodu.entity.SubjectExamClass;

import java.util.List;

public interface SubjectExamClassService {

    public List<SubjectExamClass> subjectExamClassList();
    public int insertSubjectExamClass(SubjectExamClass subjectExamClass);
    public int updateSubjectExamClass(SubjectExamClass subjectExamClass);
    public int deleteSubjectExamClass(String subjectExamClassId);
    
    
    
    
}
