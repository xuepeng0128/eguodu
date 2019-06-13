package com.yxp.eguodu.serviceimp.business;

import com.yxp.eguodu.common.queryparams.ExamQueryParams;
import com.yxp.eguodu.dao.business.ExamMapper;
import com.yxp.eguodu.entity.Exam;
import com.yxp.eguodu.entity.SubExam;
import com.yxp.eguodu.service.business.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ExamServiceImp implements ExamService {
    @Autowired
    private ExamMapper mapper;

    @Override
    public List<Exam> examList(ExamQueryParams examQueryParams) {
        return mapper.examList(examQueryParams);
    }

    @Override
    public List<Map<String, Object>> examListTotal(ExamQueryParams examQueryParams) {
        return mapper.examListTotal(examQueryParams);
    }

    @Override
    public List<SubExam> subExamList(String examId) {
        return mapper.subExamList(examId);
    }

    @Override
    public List<SubExam> initSubExamList(String schoolId, String classesId, String studySubjectId) {
        return mapper.initSubExamList(schoolId,classesId,studySubjectId);
    }

    @Override
    public int saveExam(Exam exam) {
        mapper.deleteExam(exam.getExamId());
        mapper.deleteSubExam(exam.getExamId());
        mapper.insertExam(exam);
        mapper.insertSubExam(exam.getSubExams());
        return 1;
    }

    @Override
    public int deleteExam(String examId) {
        mapper.deleteExam(examId);
        mapper.deleteSubExam(examId);
        return 1;
    }







}
