package com.sun.mytaskcenter.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Builder;
import lombok.Data;

/**
 *
 * @author zcm
 */
@Data
@Builder
public class CityInfo {

    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer cityId;
    private Integer confirmedCount;
    private Integer suspectedCount;
    private Integer curedCount;
    private Integer deadCount;
}
