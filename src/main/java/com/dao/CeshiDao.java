package com.dao;

import com.entity.CeshiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.CeshiView;

/**
 * 测试人员 Dao 接口
 *
 * @author 
 */
public interface CeshiDao extends BaseMapper<CeshiEntity> {

   List<CeshiView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
