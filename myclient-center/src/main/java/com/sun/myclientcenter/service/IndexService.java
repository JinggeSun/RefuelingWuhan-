package com.sun.myclientcenter.service;

import com.sun.myclientcenter.VO.ResultVO;

/**
 * @author zcm
 */
public interface IndexService {

    /**
     * 获取最新的消息
     * @return
     */
    ResultVO<Object> getLatest();

    /**
     * 当天地图信息
     * @return
     */
    ResultVO<Object> getTodayInfo();
}
