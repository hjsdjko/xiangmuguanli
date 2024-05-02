package com.controller;


import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;

import com.entity.*;
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

import com.entity.view.XiangmuView;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 项目
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/xiangmu")
public class XiangmuController {
    private static final Logger logger = LoggerFactory.getLogger(XiangmuController.class);

    @Autowired
    private XiangmuService xiangmuService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;



    //级联表service
    @Autowired
    private XiangmuguanliyuanService xiangmuguanliyuanService;
    @Autowired
    private XuqiuService xuqiuService;
    @Autowired
    private ChanpinjingliService chanpinjingliService;
    @Autowired
    private KaifaService kaifaService;
    @Autowired
    private CeshiService ceshiService;
    @Autowired
    private XiangmuKaifaService xiangmuKaifaService;
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
        PageUtils page = xiangmuService.queryPage(params);

        //字典表数据转换
        List<XiangmuView> list =(List<XiangmuView>)page.getList();
        for(XiangmuView c:list){
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
        XiangmuEntity xiangmu = xiangmuService.selectById(id);
        if(xiangmu !=null){
            //entity转view
            XiangmuView view = new XiangmuView();
            BeanUtils.copyProperties( xiangmu , view );//把实体数据重构到view中

            //级联表
            XiangmuguanliyuanEntity xiangmuguanliyuan = xiangmuguanliyuanService.selectById(xiangmu.getXiangmuguanliyuanId());
            if(xiangmuguanliyuan != null){
                BeanUtils.copyProperties( xiangmuguanliyuan , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                view.setXiangmuguanliyuanId(xiangmuguanliyuan.getId());
            }
            //级联表
            XuqiuEntity xuqiu = xuqiuService.selectById(xiangmu.getXuqiuId());
            if(xuqiu != null){
                BeanUtils.copyProperties( xuqiu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                view.setXuqiuId(xuqiu.getId());
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
    public R save(@RequestBody XiangmuEntity xiangmu, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,xiangmu:{}",this.getClass().getName(),xiangmu.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role)){
            return R.error(511,"权限为空");
        }
        else if("项目管理员".equals(role)){
            xiangmu.setXiangmuguanliyuanId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        }
        Wrapper<XiangmuEntity> queryWrapper = new EntityWrapper<XiangmuEntity>()
//            .eq("xiangmuguanliyuan_id", xiangmu.getXiangmuguanliyuanId())
            .eq("xuqiu_id", xiangmu.getXuqiuId())
//            .eq("xiangmu_name", xiangmu.getXiangmuName())
//            .eq("xiangmu_types", xiangmu.getXiangmuTypes())
//            .eq("xiangmu_zhuangtai_types", xiangmu.getXiangmuZhuangtaiTypes())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XiangmuEntity xiangmuEntity = xiangmuService.selectOne(queryWrapper);
        if(xiangmuEntity==null){
            xiangmu.setInsertTime(new Date());
            xiangmu.setCreateTime(new Date());
            xiangmuService.insert(xiangmu);
            return R.ok();
        }else {
            return R.error(511,"该需求已有项目");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody XiangmuEntity xiangmu, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,xiangmu:{}",this.getClass().getName(),xiangmu.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role)){
        return R.error(511,"权限为空");
        }
        else if("项目管理员".equals(role)){
            xiangmu.setXiangmuguanliyuanId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        }
        //根据字段查询是否有相同数据
        Wrapper<XiangmuEntity> queryWrapper = new EntityWrapper<XiangmuEntity>()
            .notIn("id",xiangmu.getId())
            .andNew()
//            .eq("xiangmuguanliyuan_id", xiangmu.getXiangmuguanliyuanId())
            .eq("xuqiu_id", xiangmu.getXuqiuId())
//            .eq("xiangmu_name", xiangmu.getXiangmuName())
//            .eq("xiangmu_types", xiangmu.getXiangmuTypes())
//            .eq("xiangmu_zhuangtai_types", xiangmu.getXiangmuZhuangtaiTypes())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XiangmuEntity xiangmuEntity = xiangmuService.selectOne(queryWrapper);
        if(xiangmuEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      xiangmu.set
            //  }
            xiangmuService.updateById(xiangmu);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"该需求已有项目");
        }
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        xiangmuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }






}

