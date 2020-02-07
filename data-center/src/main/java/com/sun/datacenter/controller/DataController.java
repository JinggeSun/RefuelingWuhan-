package com.sun.datacenter.controller;

import com.sun.datacenter.VO.ResultVO;
import com.sun.datacenter.service.DataService;
import com.sun.datacenter.util.ResultVOUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author zcm
 */
@RestController
@RequestMapping("/data")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DataController {

    private final DataService dataService;

    /**
     * 获取最新的数据
     * @return
     */
    @GetMapping("/latest")
    public ResultVO<Object> getLatest(){
        return ResultVOUtil.getSuccess(dataService.getLatestInfo());
    }

    @PostMapping("/info")
    public ResultVO<Object> getInfo(Date startTime,Date endTime){
        return ResultVOUtil.getSuccess(dataService.getDataInfo(startTime,endTime));
    }

    @GetMapping("/provinceInfo")
    public String  getProvinceInfo(){
        dataService.getProvinceInfo();
        return "success";
    }

}
