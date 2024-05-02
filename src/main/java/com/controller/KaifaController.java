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

import com.entity.KaifaEntity;

import com.service.KaifaService;
import com.entity.view.KaifaView;
import com.service.XiangmuguanliyuanService;
import com.service.ChanpinjingliService;
import com.service.CeshiService;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 开发人员
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/kaifa")
public class KaifaController {
    private static final Logger logger = LoggerFactory.getLogger(KaifaController.class);

    @Autowired
    private KaifaService kaifaService;


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
        PageUtils page = kaifaService.queryPage(params);

        //字典表数据转换
        List<KaifaView> list =(List<KaifaView>)page.getList();
        for(KaifaView c:list){
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
        KaifaEntity kaifa = kaifaService.selectById(id);
        if(kaifa !=null){
            //entity转view
            KaifaView view = new KaifaView();
            BeanUtils.copyProperties( kaifa , view );//把实体数据重构到view中

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
    public R save(@RequestBody KaifaEntity kaifa, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,kaifa:{}",this.getClass().getName(),kaifa.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role)){
            return R.error(511,"权限为空");
        }
        Wrapper<KaifaEntity> queryWrapper = new EntityWrapper<KaifaEntity>()
            .eq("username", kaifa.getUsername())
            .or()
            .eq("kaifa_phone", kaifa.getKaifaPhone())
            .or()
            .eq("kaifa_id_number", kaifa.getKaifaIdNumber())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        KaifaEntity kaifaEntity = kaifaService.selectOne(queryWrapper);
        if(kaifaEntity==null){
            kaifa.setCreateTime(new Date());
            kaifa.setPassword("123456");
            kaifaService.insert(kaifa);
            return R.ok();
        }else {
            return R.error(511,"账户或者身份证号或者手机号已经被使用");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody KaifaEntity kaifa, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,kaifa:{}",this.getClass().getName(),kaifa.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role)){
        return R.error(511,"权限为空");
        }
        //根据字段查询是否有相同数据
        Wrapper<KaifaEntity> queryWrapper = new EntityWrapper<KaifaEntity>()
            .notIn("id",kaifa.getId())
            .andNew()
            .eq("username", kaifa.getUsername())
            .or()
            .eq("kaifa_phone", kaifa.getKaifaPhone())
            .or()
            .eq("kaifa_id_number", kaifa.getKaifaIdNumber())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        KaifaEntity kaifaEntity = kaifaService.selectOne(queryWrapper);
        if("".equals(kaifa.getKaifaPhoto()) || "null".equals(kaifa.getKaifaPhoto())){
                kaifa.setKaifaPhoto(null);
        }
        if(kaifaEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      kaifa.set
            //  }
            kaifaService.updateById(kaifa);//根据id更新
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
        kaifaService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

    /**
    * 登录
    */
    @IgnoreAuth
    @RequestMapping(value = "/login")
    public R login(String username, String password, String captcha, HttpServletRequest request) {
        KaifaEntity kaifa = kaifaService.selectOne(new EntityWrapper<KaifaEntity>().eq("username", username));
        if(kaifa==null || !kaifa.getPassword().equals(password)) {
            return R.error("账号或密码不正确");
        }
        //  // 获取监听器中的字典表
        // ServletContext servletContext = ContextLoader.getCurrentWebApplicationContext().getServletContext();
        // Map<String, Map<Integer, String>> dictionaryMap= (Map<String, Map<Integer, String>>) servletContext.getAttribute("dictionaryMap");
        // Map<Integer, String> role_types = dictionaryMap.get("role_types");
        // role_types.get(yonghu.getRoleTypes());
        String token = tokenService.generateToken(kaifa.getId(),username, "kaifa", "开发人员");
        R r = R.ok();
        r.put("token", token);
        r.put("role","开发人员");
        r.put("username",kaifa.getKaifaName());
        r.put("tableName","kaifa");
        r.put("userId",kaifa.getId());
        return r;
    }

    /**
    * 注册
    */
    @IgnoreAuth
    @PostMapping(value = "/register")
    public R register(@RequestBody KaifaEntity kaifa){
    //    	ValidatorUtils.validateEntity(user);
        if(kaifaService.selectOne(new EntityWrapper<KaifaEntity>().eq("username", kaifa.getUsername()).orNew().eq("kaifa_phone",kaifa.getKaifaPhone()).orNew().eq("kaifa_id_number",kaifa.getKaifaIdNumber())) !=null) {
            return R.error("账户已存在或手机号或身份证号已经被使用");
        }
        kaifa.setCreateTime(new Date());
        kaifaService.insert(kaifa);
        return R.ok();
    }

    /**
     * 重置密码
     */
    @GetMapping(value = "/resetPassword")
    public R resetPassword(Integer  id){
        KaifaEntity kaifa = new KaifaEntity();
        kaifa.setPassword("123456");
        kaifa.setId(id);
        kaifaService.updateById(kaifa);
        return R.ok();
    }

    /**
    * 获取用户的session用户信息
    */
    @RequestMapping("/session")
    public R getCurrKaifa(HttpServletRequest request){
        Integer id = (Integer)request.getSession().getAttribute("userId");
        KaifaEntity kaifa = kaifaService.selectById(id);
        return R.ok().put("data", kaifa);
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

