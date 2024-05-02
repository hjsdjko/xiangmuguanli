package com.dao;

import com.entity.XuqiuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.XuqiuView;

/**
 * 需求 Dao 接口
 *
 * @author 
 */
public interface XuqiuDao extends BaseMapper<XuqiuEntity> {

   List<XuqiuView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
