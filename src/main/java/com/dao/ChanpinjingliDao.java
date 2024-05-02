package com.dao;

import com.entity.ChanpinjingliEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ChanpinjingliView;

/**
 * 产品经理 Dao 接口
 *
 * @author 
 */
public interface ChanpinjingliDao extends BaseMapper<ChanpinjingliEntity> {

   List<ChanpinjingliView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
