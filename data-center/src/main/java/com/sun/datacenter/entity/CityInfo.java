package com.sun.datacenter.entity;


import lombok.Builder;
import lombok.Data;

/**
 *
 * @author zcm
 */
@Data
@Builder
public class CityInfo {

    private Integer id;
    private Integer cityId;
    private Integer confirmedCount;
    private Integer suspectedCount;
    private Integer curedCount;
    private Integer deadCount;
}
