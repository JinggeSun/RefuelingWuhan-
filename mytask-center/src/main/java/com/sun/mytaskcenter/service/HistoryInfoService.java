package com.sun.mytaskcenter.service;

import com.sun.mytaskcenter.entity.HistoryInfo;

import java.util.Date;
import java.util.List;

/**
 * @author zcm
 */
public interface HistoryInfoService {

    /**
     * 保存
     * @param historyInfo
     */
    void saveHistory(HistoryInfo historyInfo);

    /**
     * 根据日期查找
     * @param data
     * @return
     */
    List<HistoryInfo> findByData(Date data);
}
