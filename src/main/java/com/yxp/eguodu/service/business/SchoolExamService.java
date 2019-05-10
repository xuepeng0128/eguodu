package com.yxp.eguodu.service.business;

import javax.servlet.http.HttpServletResponse;

public interface SchoolExamService {

   public String exportExamTemplate(HttpServletResponse response,String subjectFullScores,String schoolId);
}
