package com.yxp.eguodu.serviceimp.dic;

import com.yxp.eguodu.dao.dic.CircleClassMapper;
import com.yxp.eguodu.entity.CircleClass;
import com.yxp.eguodu.service.dic.CircleClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CircleClassServiceImp implements CircleClassService {
    @Autowired
    private CircleClassMapper mapper;
    @Override
    public List<CircleClass> circleClassList() {
        return mapper.circleClassList();
    }

    @Override
    public int insertCircleClass(CircleClass circleClass) {
        return mapper.insertCircleClass(circleClass);
    }

    @Override
    public int updateCircleClass(CircleClass circleClass) {
        return mapper.updateCircleClass(circleClass);
    }

    @Override
    public int deleteCircleClass(String circleClassId) {
        return mapper.deleteCircleClass(circleClassId);
    }
}
