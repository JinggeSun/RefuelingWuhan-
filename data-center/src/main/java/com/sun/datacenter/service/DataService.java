package com.sun.datacenter.service;

import com.sun.datacenter.Dto.AllInfoDto;
import com.sun.datacenter.Dto.LatestInfoDto;

import java.util.Date;

/**
 * @author zcm
 */
public interface DataService {

    /**
     * 获取所有的信息
     * @param  days 天数
     * @return
     */
    AllInfoDto getDataInfo(Date starTime, Date endTime);

    /**
     * 获取最新的消息
     * @param starTime 开始
     * @param endTime 结束
     * @return
     */
    LatestInfoDto getLatestInfo();

    /**
     * 获取省份疫情信息
     */
    void getProvinceInfo();
}
