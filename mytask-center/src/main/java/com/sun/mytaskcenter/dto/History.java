package com.sun.mytaskcenter.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zcm
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class History implements Serializable {

    private Date date;
    private Integer confirmedNum;
    private Integer suspectedNum;
    private Integer curesNum;
    private Integer deathsNum;
    private Integer suspectedIncr;
}
