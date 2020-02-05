package com.sun.datacenter.Dto;

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
public class LatestInfoDto implements Serializable {

    private Integer diagnosed;
    private Integer suspect;
    private Integer death;
    private Integer cured;
    private Date latestDate;
}
