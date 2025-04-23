
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
 * 出入库
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/zhongyaoChuruInout")
public class ZhongyaoChuruInoutController {
    private static final Logger logger = LoggerFactory.getLogger(ZhongyaoChuruInoutController.class);

    @Autowired
    private ZhongyaoChuruInoutService zhongyaoChuruInoutService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service

    // 列表详情的表级联service
    @Autowired
    private ZhongyaoChuruInoutListService zhongyaoChuruInoutListService;
//    @Autowired
//    private YonghuService yonghuService;
    @Autowired
    private ZhongyaoService zhongyaoService;
    @Autowired
    private YonghuService yonghuService;
    @Autowired
    private YuangongService yuangongService;
    @Autowired
    private HuliService huliService;
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
        PageUtils page = zhongyaoChuruInoutService.queryPage(params);

        //字典表数据转换
        List<ZhongyaoChuruInoutView> list =(List<ZhongyaoChuruInoutView>)page.getList();
        for(ZhongyaoChuruInoutView c:list){
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
        ZhongyaoChuruInoutEntity zhongyaoChuruInout = zhongyaoChuruInoutService.selectById(id);
        if(zhongyaoChuruInout !=null){
            //entity转view
            ZhongyaoChuruInoutView view = new ZhongyaoChuruInoutView();
            BeanUtils.copyProperties( zhongyaoChuruInout , view );//把实体数据重构到view中

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
    public R save(@RequestBody ZhongyaoChuruInoutEntity zhongyaoChuruInout, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,zhongyaoChuruInout:{}",this.getClass().getName(),zhongyaoChuruInout.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<ZhongyaoChuruInoutEntity> queryWrapper = new EntityWrapper<ZhongyaoChuruInoutEntity>()
            .eq("zhongyao_churu_inout_uuid_number", zhongyaoChuruInout.getZhongyaoChuruInoutUuidNumber())
            .eq("zhongyao_churu_inout_name", zhongyaoChuruInout.getZhongyaoChuruInoutName())
            .eq("zhongyao_churu_inout_types", zhongyaoChuruInout.getZhongyaoChuruInoutTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ZhongyaoChuruInoutEntity zhongyaoChuruInoutEntity = zhongyaoChuruInoutService.selectOne(queryWrapper);
        if(zhongyaoChuruInoutEntity==null){
            zhongyaoChuruInout.setInsertTime(new Date());
            zhongyaoChuruInout.setCreateTime(new Date());
            zhongyaoChuruInoutService.insert(zhongyaoChuruInout);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ZhongyaoChuruInoutEntity zhongyaoChuruInout, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,zhongyaoChuruInout:{}",this.getClass().getName(),zhongyaoChuruInout.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        //根据字段查询是否有相同数据
        Wrapper<ZhongyaoChuruInoutEntity> queryWrapper = new EntityWrapper<ZhongyaoChuruInoutEntity>()
            .notIn("id",zhongyaoChuruInout.getId())
            .andNew()
            .eq("zhongyao_churu_inout_uuid_number", zhongyaoChuruInout.getZhongyaoChuruInoutUuidNumber())
            .eq("zhongyao_churu_inout_name", zhongyaoChuruInout.getZhongyaoChuruInoutName())
            .eq("zhongyao_churu_inout_types", zhongyaoChuruInout.getZhongyaoChuruInoutTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ZhongyaoChuruInoutEntity zhongyaoChuruInoutEntity = zhongyaoChuruInoutService.selectOne(queryWrapper);
        if(zhongyaoChuruInoutEntity==null){
            zhongyaoChuruInoutService.updateById(zhongyaoChuruInout);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }
    /**
    * 出库
    */
    @RequestMapping("/outZhongyaoChuruInoutList")
    public R outZhongyaoChuruInoutList(@RequestBody  Map<String, Object> params,HttpServletRequest request){
        logger.debug("outZhongyaoChuruInoutList方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        String role = String.valueOf(request.getSession().getAttribute("role"));

        //取出入库名称并判断是否存在
        String zhongyaoChuruInoutName = String.valueOf(params.get("zhongyaoChuruInoutName"));
        Wrapper<ZhongyaoChuruInoutEntity> queryWrapper = new EntityWrapper<ZhongyaoChuruInoutEntity>()
            .eq("zhongyao_churu_inout_name", zhongyaoChuruInoutName)
            ;
        ZhongyaoChuruInoutEntity zhongyaoChuruInoutSelectOne = zhongyaoChuruInoutService.selectOne(queryWrapper);
        if(zhongyaoChuruInoutSelectOne != null)
            return R.error(511,"出入库名称已被使用");


    //取当前表的级联表并判断是否前台传入

        Map<String, Integer> map = (Map<String, Integer>) params.get("map");
        if(map == null || map.size() == 0)
            return R.error(511,"列表内容不能为空");


        Set<String> ids = map.keySet();

        List<ZhongyaoEntity> zhongyaoList = zhongyaoService.selectBatchIds(ids);
        if(zhongyaoList == null || zhongyaoList.size() == 0){
            return R.error(511,"查数据库查不到数据");
        }else{
            for(ZhongyaoEntity w:zhongyaoList){
                Integer value = w.getZhongyaoKucunNumber()-map.get(String.valueOf(w.getId()));
                if(value <0){
                    return R.error(511,"出库数量大于库存数量");
                }
                w.setZhongyaoKucunNumber(value);
            }
        }

        //当前表
        ZhongyaoChuruInoutEntity zhongyaoChuruInoutEntity = new ZhongyaoChuruInoutEntity<>();
            zhongyaoChuruInoutEntity.setZhongyaoChuruInoutUuidNumber(String.valueOf(new Date().getTime()));
            zhongyaoChuruInoutEntity.setZhongyaoChuruInoutName(zhongyaoChuruInoutName);
            zhongyaoChuruInoutEntity.setZhongyaoChuruInoutTypes(1);
            zhongyaoChuruInoutEntity.setZhongyaoChuruInoutContent("");
            zhongyaoChuruInoutEntity.setInsertTime(new Date());
            zhongyaoChuruInoutEntity.setCreateTime(new Date());

        boolean insertZhongyaoChuruInout = zhongyaoChuruInoutService.insert(zhongyaoChuruInoutEntity);
        if(insertZhongyaoChuruInout){
            //级联表
            ArrayList<ZhongyaoChuruInoutListEntity> zhongyaoChuruInoutLists = new ArrayList<>();
            for(String id:ids){
                ZhongyaoChuruInoutListEntity zhongyaoChuruInoutListEntity = new ZhongyaoChuruInoutListEntity();
                    zhongyaoChuruInoutListEntity.setZhongyaoChuruInoutId(zhongyaoChuruInoutEntity.getId());
                    zhongyaoChuruInoutListEntity.setZhongyaoId(Integer.valueOf(id));
                    zhongyaoChuruInoutListEntity.setZhongyaoChuruInoutListNumber(map.get(id));
                    zhongyaoChuruInoutListEntity.setInsertTime(new Date());
                    zhongyaoChuruInoutListEntity.setCreateTime(new Date());
                zhongyaoChuruInoutLists.add(zhongyaoChuruInoutListEntity);
                zhongyaoService.updateBatchById(zhongyaoList);
            }
            zhongyaoChuruInoutListService.insertBatch(zhongyaoChuruInoutLists);
        }
        return R.ok();
    }

    /**
    *入库
    */
    @RequestMapping("/inZhongyaoChuruInoutList")
    public R inZhongyaoChuruInoutList(@RequestBody  Map<String, Object> params,HttpServletRequest request){
        logger.debug("inZhongyaoChuruInoutList方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        //params:{"map":{"1":2,"2":3},"wuziOutinName":"订单1"}

        String role = String.valueOf(request.getSession().getAttribute("role"));

        //取当前表名称并判断
        String zhongyaoChuruInoutName = String.valueOf(params.get("zhongyaoChuruInoutName"));
        Wrapper<ZhongyaoChuruInoutEntity> queryWrapper = new EntityWrapper<ZhongyaoChuruInoutEntity>()
            .eq("zhongyao_churu_inout_name", zhongyaoChuruInoutName)
            ;
        ZhongyaoChuruInoutEntity zhongyaoChuruInoutSelectOne = zhongyaoChuruInoutService.selectOne(queryWrapper);
        if(zhongyaoChuruInoutSelectOne != null)
            return R.error(511,"出入库名称已被使用");


        //取当前表的级联表并判断是否前台传入

        Map<String, Integer> map = (Map<String, Integer>) params.get("map");
        if(map == null || map.size() == 0)
            return R.error(511,"列表内容不能为空");

        Set<String> ids = map.keySet();

        List<ZhongyaoEntity> zhongyaoList = zhongyaoService.selectBatchIds(ids);
        if(zhongyaoList == null || zhongyaoList.size() == 0){
            return R.error(511,"查数据库查不到数据");
        }else{
            for(ZhongyaoEntity w:zhongyaoList){
                w.setZhongyaoKucunNumber(w.getZhongyaoKucunNumber()+map.get(String.valueOf(w.getId())));
            }
        }

        //当前表
        ZhongyaoChuruInoutEntity zhongyaoChuruInoutEntity = new ZhongyaoChuruInoutEntity<>();
            zhongyaoChuruInoutEntity.setZhongyaoChuruInoutUuidNumber(String.valueOf(new Date().getTime()));
            zhongyaoChuruInoutEntity.setZhongyaoChuruInoutName(zhongyaoChuruInoutName);
            zhongyaoChuruInoutEntity.setZhongyaoChuruInoutTypes(2);
            zhongyaoChuruInoutEntity.setZhongyaoChuruInoutContent("");
            zhongyaoChuruInoutEntity.setInsertTime(new Date());
            zhongyaoChuruInoutEntity.setCreateTime(new Date());


        boolean insertZhongyaoChuruInout = zhongyaoChuruInoutService.insert(zhongyaoChuruInoutEntity);
        if(insertZhongyaoChuruInout){
            //级联表
            ArrayList<ZhongyaoChuruInoutListEntity> zhongyaoChuruInoutLists = new ArrayList<>();
            for(String id:ids){
                ZhongyaoChuruInoutListEntity zhongyaoChuruInoutListEntity = new ZhongyaoChuruInoutListEntity();
                zhongyaoChuruInoutListEntity.setZhongyaoChuruInoutId(zhongyaoChuruInoutEntity.getId());
                zhongyaoChuruInoutListEntity.setZhongyaoId(Integer.valueOf(id));
                zhongyaoChuruInoutListEntity.setZhongyaoChuruInoutListNumber(map.get(id));
                zhongyaoChuruInoutListEntity.setInsertTime(new Date());
                zhongyaoChuruInoutListEntity.setCreateTime(new Date());
                zhongyaoChuruInoutLists.add(zhongyaoChuruInoutListEntity);
                zhongyaoService.updateBatchById(zhongyaoList);
            }
            zhongyaoChuruInoutListService.insertBatch(zhongyaoChuruInoutLists);
        }

        return R.ok();
    }
    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        zhongyaoChuruInoutService.deleteBatchIds(Arrays.asList(ids));
        zhongyaoChuruInoutListService.delete(new EntityWrapper<ZhongyaoChuruInoutListEntity>().in("zhongyao_churu_inout_id",ids));
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
            List<ZhongyaoChuruInoutEntity> zhongyaoChuruInoutList = new ArrayList<>();//上传的东西
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
                            ZhongyaoChuruInoutEntity zhongyaoChuruInoutEntity = new ZhongyaoChuruInoutEntity();
//                            zhongyaoChuruInoutEntity.setZhongyaoChuruInoutUuidNumber(data.get(0));                    //出入库流水号 要改的
//                            zhongyaoChuruInoutEntity.setZhongyaoChuruInoutName(data.get(0));                    //出入库名称 要改的
//                            zhongyaoChuruInoutEntity.setZhongyaoChuruInoutTypes(Integer.valueOf(data.get(0)));   //出入库类型 要改的
//                            zhongyaoChuruInoutEntity.setZhongyaoChuruInoutContent("");//详情和图片
//                            zhongyaoChuruInoutEntity.setInsertTime(date);//时间
//                            zhongyaoChuruInoutEntity.setCreateTime(date);//时间
                            zhongyaoChuruInoutList.add(zhongyaoChuruInoutEntity);


                            //把要查询是否重复的字段放入map中
                                //出入库流水号
                                if(seachFields.containsKey("zhongyaoChuruInoutUuidNumber")){
                                    List<String> zhongyaoChuruInoutUuidNumber = seachFields.get("zhongyaoChuruInoutUuidNumber");
                                    zhongyaoChuruInoutUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> zhongyaoChuruInoutUuidNumber = new ArrayList<>();
                                    zhongyaoChuruInoutUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("zhongyaoChuruInoutUuidNumber",zhongyaoChuruInoutUuidNumber);
                                }
                        }

                        //查询是否重复
                         //出入库流水号
                        List<ZhongyaoChuruInoutEntity> zhongyaoChuruInoutEntities_zhongyaoChuruInoutUuidNumber = zhongyaoChuruInoutService.selectList(new EntityWrapper<ZhongyaoChuruInoutEntity>().in("zhongyao_churu_inout_uuid_number", seachFields.get("zhongyaoChuruInoutUuidNumber")));
                        if(zhongyaoChuruInoutEntities_zhongyaoChuruInoutUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(ZhongyaoChuruInoutEntity s:zhongyaoChuruInoutEntities_zhongyaoChuruInoutUuidNumber){
                                repeatFields.add(s.getZhongyaoChuruInoutUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [出入库流水号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        zhongyaoChuruInoutService.insertBatch(zhongyaoChuruInoutList);
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
        PageUtils page = zhongyaoChuruInoutService.queryPage(params);

        //字典表数据转换
        List<ZhongyaoChuruInoutView> list =(List<ZhongyaoChuruInoutView>)page.getList();
        for(ZhongyaoChuruInoutView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ZhongyaoChuruInoutEntity zhongyaoChuruInout = zhongyaoChuruInoutService.selectById(id);
            if(zhongyaoChuruInout !=null){


                //entity转view
                ZhongyaoChuruInoutView view = new ZhongyaoChuruInoutView();
                BeanUtils.copyProperties( zhongyaoChuruInout , view );//把实体数据重构到view中

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
    public R add(@RequestBody ZhongyaoChuruInoutEntity zhongyaoChuruInout, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,zhongyaoChuruInout:{}",this.getClass().getName(),zhongyaoChuruInout.toString());
        Wrapper<ZhongyaoChuruInoutEntity> queryWrapper = new EntityWrapper<ZhongyaoChuruInoutEntity>()
            .eq("zhongyao_churu_inout_uuid_number", zhongyaoChuruInout.getZhongyaoChuruInoutUuidNumber())
            .eq("zhongyao_churu_inout_name", zhongyaoChuruInout.getZhongyaoChuruInoutName())
            .eq("zhongyao_churu_inout_types", zhongyaoChuruInout.getZhongyaoChuruInoutTypes())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ZhongyaoChuruInoutEntity zhongyaoChuruInoutEntity = zhongyaoChuruInoutService.selectOne(queryWrapper);
        if(zhongyaoChuruInoutEntity==null){
            zhongyaoChuruInout.setInsertTime(new Date());
            zhongyaoChuruInout.setCreateTime(new Date());
        zhongyaoChuruInoutService.insert(zhongyaoChuruInout);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


}
