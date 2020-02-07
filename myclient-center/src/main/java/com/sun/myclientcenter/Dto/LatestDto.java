package com.sun.myclientcenter.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author zcm
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LatestDto {

    private Integer diagnosed;
    private Integer suspect;
    private Integer death;
    private Integer cured;
    private Date latestDate;
}
