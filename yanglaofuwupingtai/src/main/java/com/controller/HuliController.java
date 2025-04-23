
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
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
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 护理
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/huli")
public class HuliController {
    private static final Logger logger = LoggerFactory.getLogger(HuliController.class);

    @Autowired
    private HuliService huliService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service

    @Autowired
    private YonghuService yonghuService;
    @Autowired
    private YuangongService yuangongService;
    @Autowired
    private YishengService yishengService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("老人".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        else if("员工".equals(role))
            params.put("yuangongId",request.getSession().getAttribute("userId"));
        else if("护理".equals(role))
            params.put("huliId",request.getSession().getAttribute("userId"));
        else if("医生".equals(role))
            params.put("yishengId",request.getSession().getAttribute("userId"));
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = huliService.queryPage(params);

        //字典表数据转换
        List<HuliView> list =(List<HuliView>)page.getList();
        for(HuliView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        HuliEntity huli = huliService.selectById(id);
        if(huli !=null){
            //entity转view
            HuliView view = new HuliView();
            BeanUtils.copyProperties( huli , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody HuliEntity huli, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,huli:{}",this.getClass().getName(),huli.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<HuliEntity> queryWrapper = new EntityWrapper<HuliEntity>()
            .eq("username", huli.getUsername())
            .or()
            .eq("huli_phone", huli.getHuliPhone())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        HuliEntity huliEntity = huliService.selectOne(queryWrapper);
        if(huliEntity==null){
            huli.setCreateTime(new Date());
            huli.setPassword("123456");
            huliService.insert(huli);
            return R.ok();
        }else {
            return R.error(511,"账户或者联系方式已经被使用");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody HuliEntity huli, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,huli:{}",this.getClass().getName(),huli.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        //根据字段查询是否有相同数据
        Wrapper<HuliEntity> queryWrapper = new EntityWrapper<HuliEntity>()
            .notIn("id",huli.getId())
            .andNew()
            .eq("username", huli.getUsername())
            .or()
            .eq("huli_phone", huli.getHuliPhone())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        HuliEntity huliEntity = huliService.selectOne(queryWrapper);
        if("".equals(huli.getHuliPhoto()) || "null".equals(huli.getHuliPhoto())){
                huli.setHuliPhoto(null);
        }
        if(huliEntity==null){
            huliService.updateById(huli);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"账户或者联系方式已经被使用");
        }
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        huliService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<HuliEntity> huliList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("../../upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            HuliEntity huliEntity = new HuliEntity();
//                            huliEntity.setUsername(data.get(0));                    //账户 要改的
//                            //huliEntity.setPassword("123456");//密码
//                            huliEntity.setHuliName(data.get(0));                    //护理姓名 要改的
//                            huliEntity.setHuliPhoto("");//详情和图片
//                            huliEntity.setSexTypes(Integer.valueOf(data.get(0)));   //性别 要改的
//                            huliEntity.setHuliPhone(data.get(0));                    //联系方式 要改的
//                            huliEntity.setHuliEmail(data.get(0));                    //邮箱 要改的
//                            huliEntity.setCreateTime(date);//时间
                            huliList.add(huliEntity);


                            //把要查询是否重复的字段放入map中
                                //账户
                                if(seachFields.containsKey("username")){
                                    List<String> username = seachFields.get("username");
                                    username.add(data.get(0));//要改的
                                }else{
                                    List<String> username = new ArrayList<>();
                                    username.add(data.get(0));//要改的
                                    seachFields.put("username",username);
                                }
                                //联系方式
                                if(seachFields.containsKey("huliPhone")){
                                    List<String> huliPhone = seachFields.get("huliPhone");
                                    huliPhone.add(data.get(0));//要改的
                                }else{
                                    List<String> huliPhone = new ArrayList<>();
                                    huliPhone.add(data.get(0));//要改的
                                    seachFields.put("huliPhone",huliPhone);
                                }
                        }

                        //查询是否重复
                         //账户
                        List<HuliEntity> huliEntities_username = huliService.selectList(new EntityWrapper<HuliEntity>().in("username", seachFields.get("username")));
                        if(huliEntities_username.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(HuliEntity s:huliEntities_username){
                                repeatFields.add(s.getUsername());
                            }
                            return R.error(511,"数据库的该表中的 [账户] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //联系方式
                        List<HuliEntity> huliEntities_huliPhone = huliService.selectList(new EntityWrapper<HuliEntity>().in("huli_phone", seachFields.get("huliPhone")));
                        if(huliEntities_huliPhone.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(HuliEntity s:huliEntities_huliPhone){
                                repeatFields.add(s.getHuliPhone());
                            }
                            return R.error(511,"数据库的该表中的 [联系方式] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        huliService.insertBatch(huliList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }


    /**
    * 登录
    */
    @IgnoreAuth
    @RequestMapping(value = "/login")
    public R login(String username, String password, String captcha, HttpServletRequest request) {
        HuliEntity huli = huliService.selectOne(new EntityWrapper<HuliEntity>().eq("username", username));
        if(huli==null || !huli.getPassword().equals(password))
            return R.error("账号或密码不正确");
        //  // 获取监听器中的字典表
        // ServletContext servletContext = ContextLoader.getCurrentWebApplicationContext().getServletContext();
        // Map<String, Map<Integer, String>> dictionaryMap= (Map<String, Map<Integer, String>>) servletContext.getAttribute("dictionaryMap");
        // Map<Integer, String> role_types = dictionaryMap.get("role_types");
        // role_types.get(.getRoleTypes());
        String token = tokenService.generateToken(huli.getId(),username, "huli", "护理");
        R r = R.ok();
        r.put("token", token);
        r.put("role","护理");
        r.put("username",huli.getHuliName());
        r.put("tableName","huli");
        r.put("userId",huli.getId());
        return r;
    }

    /**
    * 注册
    */
    @IgnoreAuth
    @PostMapping(value = "/register")
    public R register(@RequestBody HuliEntity huli){
//    	ValidatorUtils.validateEntity(user);
        Wrapper<HuliEntity> queryWrapper = new EntityWrapper<HuliEntity>()
            .eq("username", huli.getUsername())
            .or()
            .eq("huli_phone", huli.getHuliPhone())
            ;
        HuliEntity huliEntity = huliService.selectOne(queryWrapper);
        if(huliEntity != null)
            return R.error("账户或者联系方式已经被使用");
        huli.setCreateTime(new Date());
        huliService.insert(huli);
        return R.ok();
    }

    /**
     * 重置密码
     */
    @GetMapping(value = "/resetPassword")
    public R resetPassword(Integer  id){
        HuliEntity huli = new HuliEntity();
        huli.setPassword("123456");
        huli.setId(id);
        huliService.updateById(huli);
        return R.ok();
    }


    /**
     * 忘记密码
     */
    @IgnoreAuth
    @RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request) {
        HuliEntity huli = huliService.selectOne(new EntityWrapper<HuliEntity>().eq("username", username));
        if(huli!=null){
            huli.setPassword("123456");
            boolean b = huliService.updateById(huli);
            if(!b){
               return R.error();
            }
        }else{
           return R.error("账号不存在");
        }
        return R.ok();
    }


    /**
    * 获取用户的session用户信息
    */
    @RequestMapping("/session")
    public R getCurrHuli(HttpServletRequest request){
        Integer id = (Integer)request.getSession().getAttribute("userId");
        HuliEntity huli = huliService.selectById(id);
        if(huli !=null){
            //entity转view
            HuliView view = new HuliView();
            BeanUtils.copyProperties( huli , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }
    }


    /**
    * 退出
    */
    @GetMapping(value = "logout")
    public R logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return R.ok("退出成功");
    }




    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        // 没有指定排序字段就默认id倒序
        if(StringUtil.isEmpty(String.valueOf(params.get("orderBy")))){
            params.put("orderBy","id");
        }
        PageUtils page = huliService.queryPage(params);

        //字典表数据转换
        List<HuliView> list =(List<HuliView>)page.getList();
        for(HuliView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        HuliEntity huli = huliService.selectById(id);
            if(huli !=null){


                //entity转view
                HuliView view = new HuliView();
                BeanUtils.copyProperties( huli , view );//把实体数据重构到view中

                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody HuliEntity huli, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,huli:{}",this.getClass().getName(),huli.toString());
        Wrapper<HuliEntity> queryWrapper = new EntityWrapper<HuliEntity>()
            .eq("username", huli.getUsername())
            .or()
            .eq("huli_phone", huli.getHuliPhone())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        HuliEntity huliEntity = huliService.selectOne(queryWrapper);
        if(huliEntity==null){
            huli.setCreateTime(new Date());
        huli.setPassword("123456");
        huliService.insert(huli);
            return R.ok();
        }else {
            return R.error(511,"账户或者联系方式已经被使用");
        }
    }


}
