package com.yxp.eguodu.serviceimp.dic;

import com.yxp.eguodu.dao.dic.RelationShipMapper;
import com.yxp.eguodu.entity.RelationShip;
import com.yxp.eguodu.service.dic.RelationShipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RelationShipServiceImp implements RelationShipService {
  @Autowired
  private RelationShipMapper mapper;

    @Override
    public List<RelationShip> relationShipList() {
        return mapper.relationShipList();
    }
}
