package com.sun.myclientcenter.controller;

import com.sun.myclientcenter.VO.ResultVO;
import com.sun.myclientcenter.service.IndexService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 主端点
 * @author zcm
 */
@RestController
@RequestMapping("/index")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class IndexController {

    private final IndexService indexService;

    @GetMapping("/latest")
    public ResultVO<Object> getLatest(){
        return indexService.getLatest();
    }

    @GetMapping("/test")
    public String test(){
        return "success";
    }

    /**
     * 获取当天地图数据
     * @return
     */
    @GetMapping("/todayInfo")
    public ResultVO<Object> todayInfo(){
        return indexService.getTodayInfo();
    }
}
