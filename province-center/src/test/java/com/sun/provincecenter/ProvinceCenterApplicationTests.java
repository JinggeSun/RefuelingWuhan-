package com.sun.provincecenter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sun.provincecenter.entity.Area;
import com.sun.provincecenter.entity.City;
import com.sun.provincecenter.entity.Province;
import com.sun.provincecenter.mapper.CityMapper;
import com.sun.provincecenter.mapper.ProvinceMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootTest
class ProvinceCenterApplicationTests {

    @Autowired(required = false)
    ProvinceMapper provinceMapper;
    @Autowired(required = false)
    CityMapper cityMapper;

    @Test
    void contextLoads() {
    }

    @Test
    void insertData(){
        RestTemplate restTemplate = new RestTemplate();
        String mess = restTemplate.getForObject("https://tianqiapi.com/api?version=epidemic&appid=55884538&appsecret=Hv992rVm",String.class);
        JSONObject jsonObject = JSON.parseObject(mess);
        System.out.println(jsonObject);
        JSONObject data = jsonObject.getJSONObject("data");
        String area = data.getString("area");
        List<Area> areaList = JSONObject.parseArray(area,Area.class);
        System.out.println(areaList.get(0).getCities());



        for (Area area1 : areaList){
            Province province = new Province();
            province.setProvinceName(area1.getProvinceName());
            province.setProvinceShortName(area1.getProvinceShortName());
            province.setPreProvinceName(area1.getPreProvinceName());
            int res = provinceMapper.insert(province);
            System.out.println(province.getId());
            if (res > 0){
                for(City city : area1.getCities()){
                    City city1 = new City();
                    city1.setCityName(city.getCityName());
                    city1.setPId(province.getId());
                    cityMapper.insert(city1);
                }
            }
        }
    }

}
