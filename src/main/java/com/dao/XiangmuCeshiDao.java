package com.dao;

import com.entity.XiangmuCeshiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.XiangmuCeshiView;

/**
 * 测试 Dao 接口
 *
 * @author 
 */
public interface XiangmuCeshiDao extends BaseMapper<XiangmuCeshiEntity> {

   List<XiangmuCeshiView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
