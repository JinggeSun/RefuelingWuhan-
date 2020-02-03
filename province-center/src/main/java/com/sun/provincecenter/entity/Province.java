package com.sun.provincecenter.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 省份表
 * @author zcm
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Province implements Serializable {

    @TableId(type = IdType.AUTO)
    private int id;
    /**
     * 城市名
     */
    private String provinceName;
    /**
     * 城市简称
     */
    private String provinceShortName;

    /**
     * 全称
     */
    private String preProvinceName;

}
