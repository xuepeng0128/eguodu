package com.yxp.eguodu.service.dic;

import com.yxp.eguodu.entity.StudySubject;

import java.util.List;

public interface StudySubjectService {
    public List<StudySubject> studySubjectList();
    public int insertStudySubject(StudySubject studySubject);
    public int updateStudySubject(StudySubject studySubject);
    public int deleteStudySubject(String studySubjectId);
}
