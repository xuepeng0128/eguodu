package com.yxp.eguodu.serviceimp.dic;

import com.yxp.eguodu.dao.dic.NationMapper;
import com.yxp.eguodu.entity.Nation;
import com.yxp.eguodu.service.dic.NationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NationServiceImp implements NationService {
    @Autowired
    private NationMapper mapper;
    @Override
    public List<Nation> nationList() {
        return mapper.nationList();
    }
}
