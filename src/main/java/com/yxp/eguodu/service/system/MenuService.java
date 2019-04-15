package com.yxp.eguodu.service.system;


import com.yxp.eguodu.entity.Menu;

import java.util.List;

public interface MenuService {
    public List<Menu> menuList(String kind);
}
