package com.yxp.eguodu.service.dic;

import com.yxp.eguodu.entity.Icon;

import java.util.List;

public interface IconService {


    public List<Icon> iconList();

    public int insertIcon(Icon icon);

    public int deleteIcon(Icon icon);

}
