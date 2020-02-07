package com.sun.myclientcenter.service.impl;

import com.sun.myclientcenter.VO.ResultVO;
import com.sun.myclientcenter.client.DataClient;
import com.sun.myclientcenter.service.IndexService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zcm
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class IndexServiceImpl implements IndexService {

    private final DataClient dataClient;

    @Override
    public ResultVO<Object> getLatest() {
        return dataClient.getLatest();
    }


    @Override
    public ResultVO<Object> getTodayInfo() {
        return null;
    }
}

