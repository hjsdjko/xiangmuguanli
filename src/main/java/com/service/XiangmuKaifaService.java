package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.XiangmuKaifaEntity;
import java.util.Map;

/**
 * 项目开发人员 服务类
 */
public interface XiangmuKaifaService extends IService<XiangmuKaifaEntity> {

    /**
    * @param params 查询参数
    * @return 带分页的查询出来的数据
    */
     PageUtils queryPage(Map<String, Object> params);
}