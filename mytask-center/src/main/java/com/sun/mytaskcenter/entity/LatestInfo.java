package com.sun.mytaskcenter.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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

    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer diagnosed;
    private Integer suspect;
    private Integer death;
    private Integer cured;
    private Date latestDate;
}
