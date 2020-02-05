package com.sun.datacenter.Dto;

import lombok.Builder;
import lombok.Data;

/**
 * @author zcm
 */
@Data
@Builder
public class CityInfoDto {

    private  String cityName;
    private Integer confirmedCount;
    private Integer suspectedCount;
    private Integer curedCount;
    private Integer deadCount;
}
