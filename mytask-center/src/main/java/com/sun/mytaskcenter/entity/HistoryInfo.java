package com.sun.mytaskcenter.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.sun.deploy.security.ValidationState;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author zcm
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HistoryInfo {

    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer confirmedNum;
    private Integer suspectedNum;
    private Integer curesNum;
    private Integer deathsNum;
    private Date historyDate;
}
