package com.sun.provincecenter.entity;

import lombok.Data;

import java.util.List;

@Data
public class Area {

    private String provinceName;
    private String provinceShortName;
    private String preProvinceName;
    private List<City> cities;

}
