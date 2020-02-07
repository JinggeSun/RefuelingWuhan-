package com.sun.mytaskcenter.Api;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sun.mytaskcenter.dto.DataDto;
import com.sun.mytaskcenter.util.HttpUtils;
import org.springframework.web.client.RestTemplate;

/**
 * @author zcm
 */
public class TianQiApi {

    public static final String TIAN_QI_API = "https://www.tianqiapi.com/api?version=epidemic&appid=55884538&appsecret=Hv992rVm";

    public DataDto getTianQin(){
        HttpUtils httpUtils = HttpUtils.getInstance();
        String res = httpUtils.sendHttpGet(TIAN_QI_API);
        JSONObject jsonObject = JSON.parseObject(res);
        String data = jsonObject.getString("data");
        DataDto dataDto = JSONObject.parseObject(data,DataDto.class);
        System.err.println(dataDto);
        return dataDto;
    }

    public DataDto getTianQi(){

        RestTemplate restTemplate = new RestTemplate();

        String mess = restTemplate.getForObject(TIAN_QI_API,String.class);

        JSONObject jsonObject = JSON.parseObject(mess);

        String data = jsonObject.getString("data");

        DataDto dataDto = JSONObject.parseObject(data,DataDto.class);

        return dataDto;
    }

}
