package com.sun.provincecenter.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 城市表
 * @author zcm
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class City implements Serializable {

    //private int id;

    /**
     * 省份id
     */
    private int pId;
    /**
     * 城市名称
     */
    private String cityName;
}
