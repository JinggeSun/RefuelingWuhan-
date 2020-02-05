package com.sun.datacenter.client;

import com.sun.datacenter.Dto.ProvinceInfoDto;
import com.sun.datacenter.VO.ResultVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @author zcm
 */
@FeignClient(name = "province-server")
public interface ProvinceClient {

    /**
     * 获取所有省份信息
     * @return
     */
    @GetMapping("/province/all")
    public ResultVO<Object> getAll();
}
