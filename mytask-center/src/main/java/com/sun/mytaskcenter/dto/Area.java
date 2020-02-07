package com.sun.mytaskcenter.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author zcm
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Area {

    private String provinceName;
    private String provinceShortName;
    private Integer confirmedCount;
    private Integer suspectedCount;
    private Integer curedCount;
    private Integer deadCount;
    private String comment;
    private String preProvinceName;

    private List<City> cities;
}
