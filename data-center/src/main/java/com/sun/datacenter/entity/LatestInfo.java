package com.sun.datacenter.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zcm
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LatestInfo implements Serializable {

    private Integer id;
    private Integer diagnosed;
    private Integer suspect;
    private Integer death;
    private Integer cured;
    private Date latestDate;

}
