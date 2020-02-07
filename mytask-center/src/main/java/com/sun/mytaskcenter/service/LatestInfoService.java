package com.sun.mytaskcenter.service;

import com.sun.mytaskcenter.entity.HistoryInfo;
import com.sun.mytaskcenter.entity.LatestInfo;

import java.util.Date;
import java.util.List;

/**
 * @author zcm
 */
public interface LatestInfoService {
    /**
     * 保存
     * @param historyInfo
     */
    void saveHistory(LatestInfo historyInfo);

    /**
     * 根据日期查找
     * @param data
     * @return
     */
    List<LatestInfo> findByData(Date data);
}
