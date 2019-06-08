package com.yxp.eguodu.serviceimp.dic;

import com.yxp.eguodu.dao.dic.ExamKindMapper;
import com.yxp.eguodu.entity.ExamKind;
import com.yxp.eguodu.service.dic.ExamKindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ExamKindServiceImp implements ExamKindService {
    @Autowired
    private ExamKindMapper mapper;
    @Override
    public List<ExamKind> examKindList() {
        return mapper.examKindList();
    }
}
