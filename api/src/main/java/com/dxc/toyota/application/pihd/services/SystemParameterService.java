package com.dxc.toyota.application.pihd.services;

import com.dxc.toyota.application.pihd.models.SystemParameterModel;
import com.dxc.toyota.application.pihd.mybatis.mapper.SystemParameterMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SystemParameterService implements ISystemParameterService {

    private final SystemParameterMapper systemParameterMapper;

    @Override
    @Transactional(readOnly = true)
    public List<SystemParameterModel> findByCategory(String category, String status) {
        return systemParameterMapper.findByCategory(category,status);
    }

    @Override
    @Transactional(rollbackFor= Exception.class)
    public int save(SystemParameterModel criteria) {
        return systemParameterMapper.save(criteria);
    }
}
