package com.yxp.eguodu.serviceimp.business;

import com.alibaba.fastjson.JSON;
import com.yxp.eguodu.common.ExcelUtil;
import com.yxp.eguodu.dao.business.SchoolExamMapper;
import com.yxp.eguodu.entity.SchoolExamExcelTemplate;
import com.yxp.eguodu.service.business.SchoolExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SchoolExamServiceImp implements SchoolExamService {
    @Autowired
    private SchoolExamMapper mapper;
    @Override
    public String exportExamTemplate(HttpServletResponse response, String subjectFullScores,String schoolId ) {
        try {
            List<SchoolExamExcelTemplate> examTemlateList =null;
            String fileName="成绩导入表";

            List<SchoolExamExcelTemplate> lista=mapper.prepareExamExcelTemp(new HashMap<String ,Object>(){{
                put("schoolId",schoolId);
            }});
            List<SchoolExamExcelTemplate> list= new ArrayList<SchoolExamExcelTemplate>();
            List<Map<String,Object>> subFullScore = new ArrayList<>(JSON.parseArray(subjectFullScores, Map.class));
            for (SchoolExamExcelTemplate t : lista){
                   for(int i =0 ;i<subFullScore.size();i++)
                   {
                       list.add(new SchoolExamExcelTemplate(t.getStudentId(),t.getStudentName(),
                                                             subFullScore.get(i).get("subjectExamClassId").toString(),
                                                             subFullScore.get(i).get("subjectExamClassName").toString(),
                                                             (Float) subFullScore.get(i).get("fullScore"),0
                                                             ));
                   }
            }
            String columnNames[] = {"学号","姓名","科目号","科目","满分","得分"};//列名

            ExcelUtil.downloadExamTemplateWorkBook(fileName,list,columnNames,response);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "excel";
    }
}
