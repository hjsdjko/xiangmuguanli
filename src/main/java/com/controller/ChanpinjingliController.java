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

import com.entity.ChanpinjingliEntity;

import com.service.ChanpinjingliService;
import com.entity.view.ChanpinjingliView;
import com.service.XiangmuguanliyuanService;
import com.service.KaifaService;
import com.service.CeshiService;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 产品经理
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/chanpinjingli")
public class ChanpinjingliController {
    private static final Logger logger = LoggerFactory.getLogger(ChanpinjingliController.class);

    @Autowired
    private ChanpinjingliService chanpinjingliService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;



    //级联表service
    @Autowired
    private XiangmuguanliyuanService xiangmuguanliyuanService;
    @Autowired
    private KaifaService kaifaService;
    @Autowired
    private CeshiService ceshiService;


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
        PageUtils page = chanpinjingliService.queryPage(params);

        //字典表数据转换
        List<ChanpinjingliView> list =(List<ChanpinjingliView>)page.getList();
        for(ChanpinjingliView c:list){
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
        ChanpinjingliEntity chanpinjingli = chanpinjingliService.selectById(id);
        if(chanpinjingli !=null){
            //entity转view
            ChanpinjingliView view = new ChanpinjingliView();
            BeanUtils.copyProperties( chanpinjingli , view );//把实体数据重构到view中

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
    public R save(@RequestBody ChanpinjingliEntity chanpinjingli, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,chanpinjingli:{}",this.getClass().getName(),chanpinjingli.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role)){
            return R.error(511,"权限为空");
        }
        Wrapper<ChanpinjingliEntity> queryWrapper = new EntityWrapper<ChanpinjingliEntity>()
            .eq("username", chanpinjingli.getUsername())
            .or()
            .eq("chanpinjingli_phone", chanpinjingli.getChanpinjingliPhone())
            .or()
            .eq("chanpinjingli_id_number", chanpinjingli.getChanpinjingliIdNumber())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ChanpinjingliEntity chanpinjingliEntity = chanpinjingliService.selectOne(queryWrapper);
        if(chanpinjingliEntity==null){
            chanpinjingli.setCreateTime(new Date());
            chanpinjingli.setPassword("123456");
            chanpinjingliService.insert(chanpinjingli);
            return R.ok();
        }else {
            return R.error(511,"账户或者身份证号或者手机号已经被使用");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ChanpinjingliEntity chanpinjingli, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,chanpinjingli:{}",this.getClass().getName(),chanpinjingli.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role)){
        return R.error(511,"权限为空");
        }
        //根据字段查询是否有相同数据
        Wrapper<ChanpinjingliEntity> queryWrapper = new EntityWrapper<ChanpinjingliEntity>()
            .notIn("id",chanpinjingli.getId())
            .andNew()
            .eq("username", chanpinjingli.getUsername())
            .or()
            .eq("chanpinjingli_phone", chanpinjingli.getChanpinjingliPhone())
            .or()
            .eq("chanpinjingli_id_number", chanpinjingli.getChanpinjingliIdNumber())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ChanpinjingliEntity chanpinjingliEntity = chanpinjingliService.selectOne(queryWrapper);
        if("".equals(chanpinjingli.getChanpinjingliPhoto()) || "null".equals(chanpinjingli.getChanpinjingliPhoto())){
                chanpinjingli.setChanpinjingliPhoto(null);
        }
        if(chanpinjingliEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      chanpinjingli.set
            //  }
            chanpinjingliService.updateById(chanpinjingli);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"账户或者身份证号或者手机号已经被使用");
        }
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        chanpinjingliService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

    /**
    * 登录
    */
    @IgnoreAuth
    @RequestMapping(value = "/login")
    public R login(String username, String password, String captcha, HttpServletRequest request) {
        ChanpinjingliEntity chanpinjingli = chanpinjingliService.selectOne(new EntityWrapper<ChanpinjingliEntity>().eq("username", username));
        if(chanpinjingli==null || !chanpinjingli.getPassword().equals(password)) {
            return R.error("账号或密码不正确");
        }
        //  // 获取监听器中的字典表
        // ServletContext servletContext = ContextLoader.getCurrentWebApplicationContext().getServletContext();
        // Map<String, Map<Integer, String>> dictionaryMap= (Map<String, Map<Integer, String>>) servletContext.getAttribute("dictionaryMap");
        // Map<Integer, String> role_types = dictionaryMap.get("role_types");
        // role_types.get(yonghu.getRoleTypes());
        String token = tokenService.generateToken(chanpinjingli.getId(),username, "chanpinjingli", "产品经理");
        R r = R.ok();
        r.put("token", token);
        r.put("role","产品经理");
        r.put("username",chanpinjingli.getChanpinjingliName());
        r.put("tableName","chanpinjingli");
        r.put("userId",chanpinjingli.getId());
        return r;
    }

    /**
    * 注册
    */
    @IgnoreAuth
    @PostMapping(value = "/register")
    public R register(@RequestBody ChanpinjingliEntity chanpinjingli){
    //    	ValidatorUtils.validateEntity(user);
        if(chanpinjingliService.selectOne(new EntityWrapper<ChanpinjingliEntity>().eq("username", chanpinjingli.getUsername()).orNew().eq("chanpinjingli_phone",chanpinjingli.getChanpinjingliPhone()).orNew().eq("chanpinjingli_id_number",chanpinjingli.getChanpinjingliIdNumber())) !=null) {
            return R.error("账户已存在或手机号或身份证号已经被使用");
        }
        chanpinjingli.setCreateTime(new Date());
        chanpinjingliService.insert(chanpinjingli);
        return R.ok();
    }

    /**
     * 重置密码
     */
    @GetMapping(value = "/resetPassword")
    public R resetPassword(Integer  id){
        ChanpinjingliEntity chanpinjingli = new ChanpinjingliEntity();
        chanpinjingli.setPassword("123456");
        chanpinjingli.setId(id);
        chanpinjingliService.updateById(chanpinjingli);
        return R.ok();
    }

    /**
    * 获取用户的session用户信息
    */
    @RequestMapping("/session")
    public R getCurrChanpinjingli(HttpServletRequest request){
        Integer id = (Integer)request.getSession().getAttribute("userId");
        ChanpinjingliEntity chanpinjingli = chanpinjingliService.selectById(id);
        return R.ok().put("data", chanpinjingli);
    }


    /**
    * 退出
    */
    @GetMapping(value = "logout")
    public R logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return R.ok("退出成功");
    }






}

