package com.dao;

import com.entity.ZhongyizhenduanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ZhongyizhenduanView;

/**
 * 中医诊断 Dao 接口
 *
 * @author 
 */
public interface ZhongyizhenduanDao extends BaseMapper<ZhongyizhenduanEntity> {

   List<ZhongyizhenduanView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
