package com.sun.provincecenter.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 省份传输实体
 * @author zcm
 */
@Data
@Builder
public class ProvinceDto {

    private int id;
    private String provinceName;
    private String preProvinceName;
    private List<CityDto> cityDtoList;
}
