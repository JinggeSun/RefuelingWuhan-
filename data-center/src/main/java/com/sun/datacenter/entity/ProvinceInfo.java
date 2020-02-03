package com.sun.datacenter.entity;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @author zcm
 */
@Data
@Builder
public class ProvinceInfo implements Serializable {

    private Integer id;
    private Integer provinceId;
    private Integer confirmedCount;
    private Integer suspectedCount;
    private Integer curedCount;
    private Integer deadCount;
    private String comment;
}
