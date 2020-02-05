package com.sun.provincecenter.service;

import com.sun.provincecenter.dto.ProvinceDto;

import java.util.List;

/**
 * @author zcm
 */
public interface ProvinceService {

    /**
     * 根据城市id获取城市信息和区域信息
     * @param id 主键
     * @return dto
     */
    ProvinceDto getProvinceById(Integer id);

    /**
     * 获取所有省份信息
     * @return
     */
    List<ProvinceDto> getAll();
}
