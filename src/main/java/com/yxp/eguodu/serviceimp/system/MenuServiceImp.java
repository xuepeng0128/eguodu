package com.yxp.eguodu.serviceimp.system;

import com.yxp.eguodu.dao.system.MenuMapper;
import com.yxp.eguodu.entity.Menu;
import com.yxp.eguodu.service.system.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImp implements MenuService {
    @Autowired
    private MenuMapper mapper;
    @Override
    public List<Menu> menuList(String kind) {
        return mapper.menuList(kind);
    }
}
