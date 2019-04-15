package com.yxp.eguodu.serviceimp.dic;

import com.yxp.eguodu.dao.dic.SubjectExamClassMapper;
import com.yxp.eguodu.entity.SubjectExamClass;
import com.yxp.eguodu.service.dic.SubjectExamClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectExamClassServiceImp implements SubjectExamClassService {
    @Autowired
    private SubjectExamClassMapper mapper;
    @Override
    public List<SubjectExamClass> subjectExamClassList() {
        return mapper.subjectExamClassList();
    }

    @Override
    public int insertSubjectExamClass(SubjectExamClass subjectExamClass) {
        return mapper.insertSubjectExamClass(subjectExamClass);
    }

    @Override
    public int updateSubjectExamClass(SubjectExamClass subjectExamClass) {
        return mapper.updateSubjectExamClass(subjectExamClass);
    }

    @Override
    public int deleteSubjectExamClass(String subjectExamClassId) {
        return mapper.deleteSubjectExamClass(subjectExamClassId);
    }
}
