package com.dao;

import com.entity.HuliEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.HuliView;

/**
 * 护理 Dao 接口
 *
 * @author 
 */
public interface HuliDao extends BaseMapper<HuliEntity> {

   List<HuliView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
