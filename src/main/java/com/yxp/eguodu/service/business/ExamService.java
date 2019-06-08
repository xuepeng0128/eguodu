package com.yxp.eguodu.service.business;

import com.yxp.eguodu.common.queryparams.ExamQueryParams;
import com.yxp.eguodu.entity.Exam;
import com.yxp.eguodu.entity.SubExam;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface ExamService {


    public List<Exam> examList(ExamQueryParams examQueryParams);

    public List<Map<String,Object>> examListTotal(ExamQueryParams examQueryParams) ;


    public List<SubExam> subExamList( String examId);
    public List<SubExam> initSubExamList( String schoolId, String classesId,  String studySubjectId);

    public int saveExam(Exam exam);

    public int deleteExam(String examId);


}
