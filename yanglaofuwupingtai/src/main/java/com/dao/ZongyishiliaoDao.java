package com.dao;

import com.entity.ZongyishiliaoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ZongyishiliaoView;

/**
 * 中医食疗 Dao 接口
 *
 * @author 
 */
public interface ZongyishiliaoDao extends BaseMapper<ZongyishiliaoEntity> {

   List<ZongyishiliaoView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
