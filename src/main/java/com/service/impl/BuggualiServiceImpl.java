package com.service.impl;

import com.utils.StringUtil;
import org.springframework.stereotype.Service;
import java.lang.reflect.Field;
import java.util.*;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;

import com.dao.BuggualiDao;
import com.entity.BuggualiEntity;
import com.service.BuggualiService;
import com.entity.view.BuggualiView;

/**
 * bug 服务实现类
 */
@Service("buggualiService")
@Transactional
public class BuggualiServiceImpl extends ServiceImpl<BuggualiDao, BuggualiEntity> implements BuggualiService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<BuggualiView> page =new Query<BuggualiView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}
