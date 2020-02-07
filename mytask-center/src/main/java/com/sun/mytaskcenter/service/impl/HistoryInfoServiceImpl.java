package com.sun.mytaskcenter.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sun.mytaskcenter.entity.HistoryInfo;
import com.sun.mytaskcenter.mapper.HistoryInfoMapper;
import com.sun.mytaskcenter.service.HistoryInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author zcm
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class HistoryInfoServiceImpl implements HistoryInfoService {

    private final HistoryInfoMapper historyInfoMapper;

    @Override
    public void saveHistory(HistoryInfo historyInfo) {
        historyInfoMapper.insert(historyInfo);
    }

    @Override
    public List<HistoryInfo> findByData(Date data) {
        QueryWrapper<HistoryInfo> queryMapper = new QueryWrapper<>();
        queryMapper.eq("history_date",data);
        return historyInfoMapper.selectList(queryMapper);
    }
}
