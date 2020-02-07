package com.sun.mytaskcenter.scheduled.client;

import com.sun.mytaskcenter.Api.TianQiApi;
import com.sun.mytaskcenter.dto.DataDto;
import com.sun.mytaskcenter.dto.History;
import com.sun.mytaskcenter.entity.HistoryInfo;
import com.sun.mytaskcenter.entity.LatestInfo;
import com.sun.mytaskcenter.mapper.HistoryInfoMapper;
import com.sun.mytaskcenter.service.HistoryInfoService;
import com.sun.mytaskcenter.service.LatestInfoService;
import com.sun.tools.javac.util.ArrayUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * 天气第三方接口的调度任务
 * @author zcm
 */
@Component
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TianQiApiScheduled {

    private static final SimpleDateFormat dayFormat = new SimpleDateFormat("yyyy_MM_dd");
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd HH:mm:ss");

    private final HistoryInfoService historyInfoService;
    private final LatestInfoService latestInfoService;

    /**
     * 历史记录的任务
     * 每3个小时跑一次
     */
    @Scheduled(cron = "0 0 0/3 * * ? *")
    public void historyInfoTask() {
        log.info("任务开始,{}", dateFormat.format(new Date()));

        TianQiApi tianQiApi = new TianQiApi();
        DataDto dataDto = tianQiApi.getTianQin();
        List<History> historyList = dataDto.getHistory();

        for (History history : historyList){
            List<HistoryInfo> list = historyInfoService.findByData(history.getDate());
            if (list.isEmpty()){
                System.err.println("empty");
                HistoryInfo historyInfo = new HistoryInfo();
                BeanUtils.copyProperties(history,historyInfo);
                historyInfo.setHistoryDate(history.getDate());
                historyInfoService.saveHistory(historyInfo);
            }else {
                System.err.println("olgggggg");
            }
        }
        log.info("任务开结束,{}", dateFormat.format(new Date()));
    }

    @Scheduled(cron = "0 0,30 0/1 * * ? ")
    //@Scheduled(fixedDelay = 50000)
    public void latestTask(){
        log.info("任务开始,{}", dateFormat.format(new Date()));

        TianQiApi tianQiApi = new TianQiApi();
        DataDto dataDto = tianQiApi.getTianQin();

        List<LatestInfo> latestInfoList = latestInfoService.findByData(dataDto.getDate());

        if (latestInfoList.isEmpty()){
            LatestInfo latestInfo = new LatestInfo();
            BeanUtils.copyProperties(dataDto,latestInfo);
            latestInfo.setLatestDate(dataDto.getDate());
            System.err.println(dataDto.getDate());
            System.err.println(latestInfo.getLatestDate());
            latestInfoService.saveHistory(latestInfo);
        }
        log.info("任务开结束,{}", dateFormat.format(new Date()));
    }
}
