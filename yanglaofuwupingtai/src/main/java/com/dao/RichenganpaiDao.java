package com.dao;

import com.entity.RichenganpaiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.RichenganpaiView;

/**
 * 日程安排 Dao 接口
 *
 * @author 
 */
public interface RichenganpaiDao extends BaseMapper<RichenganpaiEntity> {

   List<RichenganpaiView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
