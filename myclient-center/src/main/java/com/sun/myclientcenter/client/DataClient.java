package com.sun.myclientcenter.client;

import com.sun.myclientcenter.VO.ResultVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 调用数据中心的接口
 * @author zcm
 */
@FeignClient(name = "data-server")
public interface DataClient {

    /**
     * 获取最新的数据
     * @return
     */
    @GetMapping("/data/latest")
    ResultVO<Object> getLatest();



}
