package com.sun.mytaskcenter.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sun.mytaskcenter.entity.HistoryInfo;
import com.sun.mytaskcenter.entity.LatestInfo;
import com.sun.mytaskcenter.mapper.LatestInfoMapper;
import com.sun.mytaskcenter.service.LatestInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class LatestInfoServiceImpl implements LatestInfoService {

    private final LatestInfoMapper latestInfoMapper;

    @Override
    public void saveHistory(LatestInfo historyInfo) {
        latestInfoMapper.insert(historyInfo);
    }

    @Override
    public List<LatestInfo> findByData(Date data) {
        QueryWrapper<LatestInfo> queryMapper = new QueryWrapper<>();
        queryMapper.eq("latest_date",data);
        return latestInfoMapper.selectList(queryMapper);
    }
}
