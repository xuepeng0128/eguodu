package com.yxp.eguodu.serviceimp.dic;

import com.yxp.eguodu.dao.dic.StudySubjectMapper;
import com.yxp.eguodu.entity.StudySubject;
import com.yxp.eguodu.service.dic.StudySubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudySubjectServiceImp implements StudySubjectService {
    @Autowired
    private StudySubjectMapper mapper;
    @Override
    public List<StudySubject> studySubjectList() {
        return mapper.studySubjectList();
    }

    @Override
    public int insertStudySubject(StudySubject studySubject) {
        return mapper.insertStudySubject(studySubject);
    }

    @Override
    public int updateStudySubject(StudySubject studySubject) {
        return mapper.updateStudySubject(studySubject);
    }

    @Override
    public int deleteStudySubject(String studySubjectId) {
        return mapper.deleteStudySubject(studySubjectId);
    }
}
