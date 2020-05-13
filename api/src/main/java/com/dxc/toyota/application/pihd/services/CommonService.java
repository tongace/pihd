package com.dxc.toyota.application.pihd.services;

import com.dxc.toyota.application.pihd.mybatis.mapper.CommonMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
@Service
@RequiredArgsConstructor
public class CommonService implements ICommonService {
    private final CommonMapper commonMapper;
    @Override
    @Transactional(readOnly = true)
    public Date getDatabaseDateTime() {
        return commonMapper.getDbDateTime();
    }
}
