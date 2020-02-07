package com.sun.mytaskcenter.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @author zcm
 */
@Data
@Builder
public class ProvinceInfo implements Serializable {

    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer provinceId;
    private Integer confirmedCount;
    private Integer suspectedCount;
    private Integer curedCount;
    private Integer deadCount;
    private String comment;
}
