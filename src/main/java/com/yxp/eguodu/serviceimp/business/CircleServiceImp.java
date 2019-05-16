package com.yxp.eguodu.serviceimp.business;

import com.yxp.eguodu.common.queryparams.CircleQueryParams;
import com.yxp.eguodu.dao.business.CircleMapper;
import com.yxp.eguodu.entity.Circle;
import com.yxp.eguodu.service.business.CircleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CircleServiceImp implements CircleService {
    @Autowired
    private CircleMapper mapper;
    @Override
    public List<Map<String, Object>> circleList(CircleQueryParams circleQueryParams) {
        return mapper.circleList(circleQueryParams);
    }

    @Override
    public List<Map<String, Object>> circleListTotal(CircleQueryParams circleQueryParams) {
        return mapper.circleListTotal(circleQueryParams);
    }

    @Override
    public int insertCircle(Circle circle) {
        return mapper.insertCircle(circle);
    }

    @Override
    public int updateCircle(Circle circle) {
        return mapper.updateCircle(circle);
    }

    @Override
    public int deleteCircle(Map<String, Object> paras) {
        return mapper.deleteCircle(paras);
    }

    @Override
    public int closeCircle(Map<String, Object> paras) {
        return mapper.closeCircle(paras);
    }
}
