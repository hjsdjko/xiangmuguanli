package com.dao;

import com.entity.XiangmuguanliyuanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.XiangmuguanliyuanView;

/**
 * 项目管理员 Dao 接口
 *
 * @author 
 */
public interface XiangmuguanliyuanDao extends BaseMapper<XiangmuguanliyuanEntity> {

   List<XiangmuguanliyuanView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
