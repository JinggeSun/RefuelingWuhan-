package com.sun.datacenter.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sun.datacenter.Dto.AllInfoDto;
import com.sun.datacenter.Dto.HistoryInfoDto;
import com.sun.datacenter.Dto.LatestInfoDto;
import com.sun.datacenter.Dto.ProvinceInfoDto;
import com.sun.datacenter.VO.ResultVO;
import com.sun.datacenter.client.ProvinceClient;
import com.sun.datacenter.entity.HistoryInfo;
import com.sun.datacenter.entity.LatestInfo;
import com.sun.datacenter.entity.ProvinceInfo;
import com.sun.datacenter.mapper.CityInfoMapper;
import com.sun.datacenter.mapper.HistoryInfoMapper;
import com.sun.datacenter.mapper.LatestInfoMapper;
import com.sun.datacenter.mapper.ProvinceInfoMapper;
import com.sun.datacenter.service.DataService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zcm
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DataServiceImpl implements DataService {

    private final HistoryInfoMapper historyInfoMapper;
    private final LatestInfoMapper latestInfoMapper;
    private final ProvinceInfoMapper provinceInfoMapper;
    private final CityInfoMapper cityInfoMapper;
    private final ProvinceClient provinceClient;

    @Override
    public AllInfoDto getDataInfo(Date starTime, Date endTime) {
        LatestInfoDto latestInfoDto = getLatestInfo();
        QueryWrapper<HistoryInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.between("history_date",starTime,endTime);
        List<HistoryInfo> historyInfoList = historyInfoMapper.selectList(queryWrapper);
        List<HistoryInfoDto> historyInfoDtoList = historyInfoList.stream().map(historyInfo -> {
            HistoryInfoDto historyInfoDto = new HistoryInfoDto();
            BeanUtils.copyProperties(historyInfo,historyInfoDto);
            return historyInfoDto;
        }).collect(Collectors.toList());
        return AllInfoDto.builder().latestInfoDto(latestInfoDto).historyInfoDtoList(historyInfoDtoList).build();
    }

    @Override
    public LatestInfoDto getLatestInfo() {
        LatestInfo latestInfo = latestInfoMapper.selectLatestInfo();
        LatestInfoDto latestInfoDto = new LatestInfoDto();
        BeanUtils.copyProperties(latestInfo,latestInfoDto);
        return latestInfoDto;
    }

    @Override
    public void getProvinceInfo(){
        List<ProvinceInfo> provinceInfoList = provinceInfoMapper.selectList(new QueryWrapper<>());

        List<ProvinceInfoDto> provinceInfoDtoList = provinceInfoList.stream().map(provinceInfo -> {
            ProvinceInfoDto provinceInfoDto = new ProvinceInfoDto();
            BeanUtils.copyProperties(provinceInfo,provinceInfoDto);
            return provinceInfoDto;
        }).collect(Collectors.toList());

        ResultVO<Object> resultVO = provinceClient.getAll();

        System.out.println(resultVO);

    }
}
