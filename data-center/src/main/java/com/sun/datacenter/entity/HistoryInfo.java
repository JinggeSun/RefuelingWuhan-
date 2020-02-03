package com.sun.datacenter.entity;


import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * @author zcm
 */
@Data
@Builder
public class HistoryInfo {

    private Integer id;
    private Integer confirmedNum;
    private Integer suspectedNum;
    private Integer curesNum;
    private Integer deathsNum;
    private Date historyDate;
}
