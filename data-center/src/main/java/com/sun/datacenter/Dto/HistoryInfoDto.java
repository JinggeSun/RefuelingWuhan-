package com.sun.datacenter.Dto;

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
@NoArgsConstructor
@AllArgsConstructor
public class HistoryInfoDto {

    private Integer confirmedNum;
    private Integer suspectedNum;
    private Integer curesNum;
    private Integer deathsNum;
    private Date historyDate;
}
