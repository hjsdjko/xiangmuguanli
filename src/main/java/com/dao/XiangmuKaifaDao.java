package com.dao;

import com.entity.XiangmuKaifaEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.XiangmuKaifaView;

/**
 * 项目开发人员 Dao 接口
 *
 * @author 
 */
public interface XiangmuKaifaDao extends BaseMapper<XiangmuKaifaEntity> {

   List<XiangmuKaifaView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
