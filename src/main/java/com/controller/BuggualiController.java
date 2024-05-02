package com.controller;


import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.StringUtil;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

import com.entity.BuggualiEntity;

import com.service.BuggualiService;
import com.entity.view.BuggualiView;
import com.service.CeshiService;
import com.entity.CeshiEntity;
import com.service.XiangmuService;
import com.entity.XiangmuEntity;
import com.service.XiangmuguanliyuanService;
import com.service.ChanpinjingliService;
import com.service.KaifaService;
import com.utils.PageUtils;
import com.utils.R;

/**
 * bug
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/bugguali")
public class BuggualiController {
    private static final Logger logger = LoggerFactory.getLogger(BuggualiController.class);

    @Autowired
    private BuggualiService buggualiService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;



    //级联表service
    @Autowired
    private CeshiService ceshiService;
    @Autowired
    private XiangmuService xiangmuService;
    @Autowired
    private XiangmuguanliyuanService xiangmuguanliyuanService;
    @Autowired
    private ChanpinjingliService chanpinjingliService;
    @Autowired
    private KaifaService kaifaService;


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
            params.put("kaifaId",request.getSession().getAttribute("userId"));
        }
        else if("测试人员".equals(role)){
            params.put("ceshiId",request.getSession().getAttribute("userId"));
        }
        params.put("orderBy","id");
        PageUtils page = buggualiService.queryPage(params);

        //字典表数据转换
        List<BuggualiView> list =(List<BuggualiView>)page.getList();
        for(BuggualiView c:list){
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
        BuggualiEntity bugguali = buggualiService.selectById(id);
        if(bugguali !=null){
            //entity转view
            BuggualiView view = new BuggualiView();
            BeanUtils.copyProperties( bugguali , view );//把实体数据重构到view中

            //级联表
            CeshiEntity ceshi = ceshiService.selectById(bugguali.getCeshiId());
            if(ceshi != null){
                BeanUtils.copyProperties( ceshi , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                view.setCeshiId(ceshi.getId());
            }
            //级联表
            XiangmuEntity xiangmu = xiangmuService.selectById(bugguali.getXiangmuId());
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
    public R save(@RequestBody BuggualiEntity bugguali, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,bugguali:{}",this.getClass().getName(),bugguali.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role)){
            return R.error(511,"权限为空");
        }
        else if("测试人员".equals(role)){
            bugguali.setCeshiId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
            bugguali.setBuggualiChuliTypes(1);
        }
//        Wrapper<BuggualiEntity> queryWrapper = new EntityWrapper<BuggualiEntity>()
//            .eq("ceshi_id", bugguali.getCeshiId())
//            .eq("xiangmu_id", bugguali.getXiangmuId())
//            .eq("bugguali_name", bugguali.getBuggualiName())
//            .eq("bugguali_types", bugguali.getBuggualiTypes())
//            .eq("bugguali_chuli_types", bugguali.getBuggualiChuliTypes())
//            ;
//        logger.info("sql语句:"+queryWrapper.getSqlSegment());
//        BuggualiEntity buggualiEntity = buggualiService.selectOne(queryWrapper);
//        if(buggualiEntity==null){
            bugguali.setInsertTime(new Date());
            bugguali.setCreateTime(new Date());
            buggualiService.insert(bugguali);
            return R.ok();
//        }else {
//            return R.error(511,"表中有相同数据");
//        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody BuggualiEntity bugguali, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,bugguali:{}",this.getClass().getName(),bugguali.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role)){
        return R.error(511,"权限为空");
        }
        else if("测试人员".equals(role)){
            bugguali.setCeshiId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        }
//        //根据字段查询是否有相同数据
//        Wrapper<BuggualiEntity> queryWrapper = new EntityWrapper<BuggualiEntity>()
//            .notIn("id",bugguali.getId())
//            .andNew()
//            .eq("ceshi_id", bugguali.getCeshiId())
//            .eq("xiangmu_id", bugguali.getXiangmuId())
//            .eq("bugguali_name", bugguali.getBuggualiName())
//            .eq("bugguali_types", bugguali.getBuggualiTypes())
//            .eq("bugguali_chuli_types", bugguali.getBuggualiChuliTypes())
//            ;
//        logger.info("sql语句:"+queryWrapper.getSqlSegment());
//        BuggualiEntity buggualiEntity = buggualiService.selectOne(queryWrapper);
//        if(buggualiEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      bugguali.set
            //  }
            buggualiService.updateById(bugguali);//根据id更新
            return R.ok();
//        }else {
//            return R.error(511,"表中有相同数据");
//        }
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        buggualiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }






}

