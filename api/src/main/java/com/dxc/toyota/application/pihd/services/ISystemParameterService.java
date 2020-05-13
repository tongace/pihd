package com.dxc.toyota.application.pihd.services;

import com.dxc.toyota.application.pihd.models.SystemParameterModel;

import java.util.List;

public interface ISystemParameterService {
    public List<SystemParameterModel> findByCategory(String category, String status);
    public int save(SystemParameterModel criteria);
}
