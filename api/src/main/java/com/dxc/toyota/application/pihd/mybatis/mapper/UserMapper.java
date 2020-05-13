package com.dxc.toyota.application.pihd.mybatis.mapper;

import com.dxc.toyota.application.pihd.models.UserModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    public UserModel findByUserId(@Param("userId") String userId);
}
