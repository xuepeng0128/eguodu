package com.yxp.eguodu.serviceimp.dic;

import com.yxp.eguodu.dao.dic.IconMapper;
import com.yxp.eguodu.entity.Icon;
import com.yxp.eguodu.service.dic.IconService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IconServiceImp implements IconService {
    @Autowired
    private IconMapper mapper;
    @Override
    public List<Icon> iconList() {
        return mapper.iconList();
    }

    @Override
    public int insertIcon(Icon icon) {
        return mapper.insertIcon(icon);
    }

    @Override
    public int deleteIcon(Icon icon) {
        return mapper.deleteIcon(icon);
    }
}
