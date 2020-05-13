package com.dxc.toyota.application.pihd.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.Date;

@Mapper
public interface CommonMapper {
    public Date getDbDateTime();
}
