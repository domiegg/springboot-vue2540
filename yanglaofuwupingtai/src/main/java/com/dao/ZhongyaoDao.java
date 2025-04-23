package com.dao;

import com.entity.ZhongyaoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ZhongyaoView;

/**
 * 中药信息 Dao 接口
 *
 * @author 
 */
public interface ZhongyaoDao extends BaseMapper<ZhongyaoEntity> {

   List<ZhongyaoView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
