package com.sun.datacenter.Dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @author zcm
 */
@Data
@Builder
public class AllInfoDto {

    private LatestInfoDto latestInfoDto;
    private List<HistoryInfoDto> historyInfoDtoList;
}
