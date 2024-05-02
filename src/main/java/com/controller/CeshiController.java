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

import com.entity.CeshiEntity;

import com.service.CeshiService;
import com.entity.view.CeshiView;
import com.service.XiangmuguanliyuanService;
import com.service.ChanpinjingliService;
import com.service.KaifaService;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 测试人员
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/ceshi")
public class CeshiController {
    private static final Logger logger = LoggerFactory.getLogger(CeshiController.class);

    @Autowired
    private CeshiService ceshiService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;



    //级联表service
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
        PageUtils page = ceshiService.queryPage(params);

        //字典表数据转换
        List<CeshiView> list =(List<CeshiView>)page.getList();
        for(CeshiView c:list){
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
        CeshiEntity ceshi = ceshiService.selectById(id);
        if(ceshi !=null){
            //entity转view
            CeshiView view = new CeshiView();
            BeanUtils.copyProperties( ceshi , view );//把实体数据重构到view中

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
    public R save(@RequestBody CeshiEntity ceshi, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,ceshi:{}",this.getClass().getName(),ceshi.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role)){
            return R.error(511,"权限为空");
        }
        Wrapper<CeshiEntity> queryWrapper = new EntityWrapper<CeshiEntity>()
            .eq("username", ceshi.getUsername())
            .or()
            .eq("ceshi_phone", ceshi.getCeshiPhone())
            .or()
            .eq("ceshi_id_number", ceshi.getCeshiIdNumber())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        CeshiEntity ceshiEntity = ceshiService.selectOne(queryWrapper);
        if(ceshiEntity==null){
            ceshi.setCreateTime(new Date());
            ceshi.setPassword("123456");
            ceshiService.insert(ceshi);
            return R.ok();
        }else {
            return R.error(511,"账户或者身份证号或者手机号已经被使用");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody CeshiEntity ceshi, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,ceshi:{}",this.getClass().getName(),ceshi.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role)){
        return R.error(511,"权限为空");
        }
        //根据字段查询是否有相同数据
        Wrapper<CeshiEntity> queryWrapper = new EntityWrapper<CeshiEntity>()
            .notIn("id",ceshi.getId())
            .andNew()
            .eq("username", ceshi.getUsername())
            .or()
            .eq("ceshi_phone", ceshi.getCeshiPhone())
            .or()
            .eq("ceshi_id_number", ceshi.getCeshiIdNumber())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        CeshiEntity ceshiEntity = ceshiService.selectOne(queryWrapper);
        if("".equals(ceshi.getCeshiPhoto()) || "null".equals(ceshi.getCeshiPhoto())){
                ceshi.setCeshiPhoto(null);
        }
        if(ceshiEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      ceshi.set
            //  }
            ceshiService.updateById(ceshi);//根据id更新
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
        ceshiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

    /**
    * 登录
    */
    @IgnoreAuth
    @RequestMapping(value = "/login")
    public R login(String username, String password, String captcha, HttpServletRequest request) {
        CeshiEntity ceshi = ceshiService.selectOne(new EntityWrapper<CeshiEntity>().eq("username", username));
        if(ceshi==null || !ceshi.getPassword().equals(password)) {
            return R.error("账号或密码不正确");
        }
        //  // 获取监听器中的字典表
        // ServletContext servletContext = ContextLoader.getCurrentWebApplicationContext().getServletContext();
        // Map<String, Map<Integer, String>> dictionaryMap= (Map<String, Map<Integer, String>>) servletContext.getAttribute("dictionaryMap");
        // Map<Integer, String> role_types = dictionaryMap.get("role_types");
        // role_types.get(yonghu.getRoleTypes());
        String token = tokenService.generateToken(ceshi.getId(),username, "ceshi", "测试人员");
        R r = R.ok();
        r.put("token", token);
        r.put("role","测试人员");
        r.put("username",ceshi.getCeshiName());
        r.put("tableName","ceshi");
        r.put("userId",ceshi.getId());
        return r;
    }

    /**
    * 注册
    */
    @IgnoreAuth
    @PostMapping(value = "/register")
    public R register(@RequestBody CeshiEntity ceshi){
    //    	ValidatorUtils.validateEntity(user);
        if(ceshiService.selectOne(new EntityWrapper<CeshiEntity>().eq("username", ceshi.getUsername()).orNew().eq("ceshi_phone",ceshi.getCeshiPhone()).orNew().eq("ceshi_id_number",ceshi.getCeshiIdNumber())) !=null) {
            return R.error("账户已存在或手机号或身份证号已经被使用");
        }
        ceshi.setCreateTime(new Date());
        ceshiService.insert(ceshi);
        return R.ok();
    }

    /**
     * 重置密码
     */
    @GetMapping(value = "/resetPassword")
    public R resetPassword(Integer  id){
        CeshiEntity ceshi = new CeshiEntity();
        ceshi.setPassword("123456");
        ceshi.setId(id);
        ceshiService.updateById(ceshi);
        return R.ok();
    }

    /**
    * 获取用户的session用户信息
    */
    @RequestMapping("/session")
    public R getCurrCeshi(HttpServletRequest request){
        Integer id = (Integer)request.getSession().getAttribute("userId");
        CeshiEntity ceshi = ceshiService.selectById(id);
        return R.ok().put("data", ceshi);
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

