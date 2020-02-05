package com.sun.provincecenter.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sun.provincecenter.dto.CityDto;
import com.sun.provincecenter.dto.ProvinceDto;
import com.sun.provincecenter.entity.City;
import com.sun.provincecenter.entity.Province;
import com.sun.provincecenter.enums.ResultEnums;
import com.sun.provincecenter.exception.ProvinceException;
import com.sun.provincecenter.mapper.CityMapper;
import com.sun.provincecenter.mapper.ProvinceMapper;
import com.sun.provincecenter.service.ProvinceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 实现类
 * @author zcm
 */
@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProvinceServiceImpl implements ProvinceService {

    private final ProvinceMapper provinceMapper;
    private final CityMapper cityMapper;

    @Override
    public ProvinceDto getProvinceById(Integer id) {

        Province province = provinceMapper.selectById(id);

        if (null == province){
            throw  new ProvinceException(ResultEnums.SEARCH_ERROR);
        }

        QueryWrapper<City> queryWrapper = new QueryWrapper<City>();
        queryWrapper.eq("p_id",province.getId());
        List<City> cityList = cityMapper.selectList(queryWrapper);
        List<CityDto> cityDtoList = cityList.stream().map(city -> {
            return CityDto.builder().cityName(city.getCityName()).build();
        }).collect(Collectors.toList());

        return ProvinceDto.builder().id(province.getId()).provinceName(province.getProvinceName()).cityDtoList(cityDtoList).build();
    }

    @Override
    public List<ProvinceDto> getAll() {
        List<Province> provinceList = provinceMapper.selectList(new QueryWrapper<>());
        return provinceList.stream().map(province -> {
            ProvinceDto provinceDto = new ProvinceDto();
            BeanUtils.copyProperties(province,provinceDto);
            return provinceDto;
        }).collect(Collectors.toList());
    }
}
