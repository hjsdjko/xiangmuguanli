package com.controller;


import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;

import com.entity.XiangmuCeshiEntity;
import com.service.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;

import com.utils.StringUtil;
import java.lang.reflect.InvocationTargetException;

import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

import com.entity.XiangmuKaifaEntity;

import com.entity.view.XiangmuKaifaView;
import com.entity.KaifaEntity;
import com.entity.XiangmuEntity;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 项目开发人员
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/xiangmuKaifa")
public class XiangmuKaifaController {
    private static final Logger logger = LoggerFactory.getLogger(XiangmuKaifaController.class);

    @Autowired
    private XiangmuKaifaService xiangmuKaifaService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;



    //级联表service
    @Autowired
    private KaifaService kaifaService;
    @Autowired
    private XiangmuService xiangmuService;
    @Autowired
    private XiangmuguanliyuanService xiangmuguanliyuanService;
    @Autowired
    private ChanpinjingliService chanpinjingliService;
    @Autowired
    private CeshiService ceshiService;
    @Autowired
    private XiangmuCeshiService xiangmuCeshiService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role)){
            return R.error(511,"权限为空");
        }
        else if("项目管理员".equals(role)){
            params.put("xiangmuguanliyuanId",request.getSession().getAttribute("userId"));
        }
        else if("产品经理".equals(role)){
            params.put("chanpinjingliId",request.getSession().getAttribute("userId"));
        }
        else if("开发人员".equals(role)){
            Wrapper<XiangmuKaifaEntity> queryWrapper = new EntityWrapper<XiangmuKaifaEntity>()
                    .eq("kaifa_id",Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
            List<XiangmuKaifaEntity> xiangmuKaifaEntities = xiangmuKaifaService.selectList(queryWrapper);
            List<Integer> ids = new ArrayList<>();
            for(XiangmuKaifaEntity x:xiangmuKaifaEntities){
                ids.add(x.getXiangmuId());
            }
            if(ids!= null  && ids.size()>0){
                params.put("ids",ids);
            }
        }
        else if("测试人员".equals(role)){
            Wrapper<XiangmuCeshiEntity> queryWrapper = new EntityWrapper<XiangmuCeshiEntity>()
                    .eq("ceshi_id",Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
            List<XiangmuCeshiEntity> xiangmuKaifaEntities = xiangmuCeshiService.selectList(queryWrapper);
            List<Integer> ids = new ArrayList<>();
            for(XiangmuCeshiEntity x:xiangmuKaifaEntities){
                ids.add(x.getXiangmuId());
            }
            if(ids!= null  && ids.size()>0){
                params.put("ids",ids);
            }
        }
        params.put("orderBy","id");
        PageUtils page = xiangmuKaifaService.queryPage(params);

        //字典表数据转换
        List<XiangmuKaifaView> list =(List<XiangmuKaifaView>)page.getList();
        for(XiangmuKaifaView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        XiangmuKaifaEntity xiangmuKaifa = xiangmuKaifaService.selectById(id);
        if(xiangmuKaifa !=null){
            //entity转view
            XiangmuKaifaView view = new XiangmuKaifaView();
            BeanUtils.copyProperties( xiangmuKaifa , view );//把实体数据重构到view中

            //级联表
            KaifaEntity kaifa = kaifaService.selectById(xiangmuKaifa.getKaifaId());
            if(kaifa != null){
                BeanUtils.copyProperties( kaifa , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                view.setKaifaId(kaifa.getId());
            }
            //级联表
            XiangmuEntity xiangmu = xiangmuService.selectById(xiangmuKaifa.getXiangmuId());
            if(xiangmu != null){
                BeanUtils.copyProperties( xiangmu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                view.setXiangmuId(xiangmu.getId());
            }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody XiangmuKaifaEntity xiangmuKaifa, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,xiangmuKaifa:{}",this.getClass().getName(),xiangmuKaifa.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role)){
            return R.error(511,"权限为空");
        }
        else if("开发人员".equals(role)){
            xiangmuKaifa.setKaifaId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        }
        Wrapper<XiangmuKaifaEntity> queryWrapper = new EntityWrapper<XiangmuKaifaEntity>()
            .eq("xiangmu_id", xiangmuKaifa.getXiangmuId())
            .eq("kaifa_id", xiangmuKaifa.getKaifaId())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XiangmuKaifaEntity xiangmuKaifaEntity = xiangmuKaifaService.selectOne(queryWrapper);
        if(xiangmuKaifaEntity==null){
            xiangmuKaifa.setInsertTime(new Date());
            xiangmuKaifa.setCreateTime(new Date());
            xiangmuKaifaService.insert(xiangmuKaifa);
            return R.ok();
        }else {
            return R.error(511,"该人员已经在本项目中");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody XiangmuKaifaEntity xiangmuKaifa, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,xiangmuKaifa:{}",this.getClass().getName(),xiangmuKaifa.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role)){
        return R.error(511,"权限为空");
        }
        else if("开发人员".equals(role)){
            xiangmuKaifa.setKaifaId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        }
        //根据字段查询是否有相同数据
        Wrapper<XiangmuKaifaEntity> queryWrapper = new EntityWrapper<XiangmuKaifaEntity>()
            .notIn("id",xiangmuKaifa.getId())
            .andNew()
            .eq("xiangmu_id", xiangmuKaifa.getXiangmuId())
            .eq("kaifa_id", xiangmuKaifa.getKaifaId())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XiangmuKaifaEntity xiangmuKaifaEntity = xiangmuKaifaService.selectOne(queryWrapper);
        if(xiangmuKaifaEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      xiangmuKaifa.set
            //  }
            xiangmuKaifaService.updateById(xiangmuKaifa);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"该人员已经在本项目中");
        }
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        xiangmuKaifaService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }






}

