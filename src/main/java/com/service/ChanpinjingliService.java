package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ChanpinjingliEntity;
import java.util.Map;

/**
 * 产品经理 服务类
 */
public interface ChanpinjingliService extends IService<ChanpinjingliEntity> {

    /**
    * @param params 查询参数
    * @return 带分页的查询出来的数据
    */
     PageUtils queryPage(Map<String, Object> params);
}