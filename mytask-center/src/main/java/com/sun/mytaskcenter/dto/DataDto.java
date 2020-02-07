package com.sun.mytaskcenter.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * @author zcm
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataDto {

    private Date date;
    private Integer diagnosed;
    private Integer suspect;
    private Integer death;
    private Integer cured;
    private Integer serious;
    private Integer diagnosedIncr;
    private Integer suspectIncr;
    private Integer deathIncr;
    private Integer curedIncr;
    private Integer seriousIncr;

    private List<History> history;
    private List<Area> area;
}
