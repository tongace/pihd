package com.dxc.toyota.application.pihd.mybatis.mapper;

import com.dxc.toyota.application.pihd.models.SystemParameterModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface SystemParameterMapper {
    public SystemParameterModel findByPrimaryKey(@Param("id") String id, @Param("status") String status);
    public List<SystemParameterModel> findByCategory(@Param("category") String category, @Param("status") String status);
    public List<SystemParameterModel> findSystemParameters(SystemParameterModel criteria);
    public int save(SystemParameterModel criteria);
    public int update(SystemParameterModel criteria);
    public int delete(@Param("id") String id);
}
