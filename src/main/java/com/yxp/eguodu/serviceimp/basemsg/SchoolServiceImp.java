package com.yxp.eguodu.serviceimp.basemsg;

import com.yxp.eguodu.common.queryparams.SchoolQueryParams;
import com.yxp.eguodu.dao.basemsg.SchoolMapper;
import com.yxp.eguodu.entity.School;
import com.yxp.eguodu.service.basemsg.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SchoolServiceImp implements SchoolService {
    @Autowired
    private SchoolMapper mapper;
    @Override
    public List<Map<String, Object>> schoolList(SchoolQueryParams schoolQueryParams) {
        return mapper.schoolList(schoolQueryParams);
    }
    @Override
    public List<Map<String, Object>> schoolListTotal(SchoolQueryParams schoolQueryParams) {
        return mapper.schoolListTotal(schoolQueryParams);
    }

    @Override
    public List<Map<String, Object>> schoolListByAreaAndName(String districtId, String schoolName) {
        return mapper.schoolListByAreaAndName(districtId,schoolName);
    }

    @Override
    public int insertSchool(School school) {
        return mapper.insertSchool(school);
    }

    @Override
    public int updateSchool(School school) {
        return mapper.updateSchool(school);
    }
}
