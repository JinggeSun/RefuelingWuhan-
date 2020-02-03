package com.sun.provincecenter.controller;

import com.sun.provincecenter.VO.ResultVO;
import com.sun.provincecenter.dto.ProvinceDto;
import com.sun.provincecenter.enums.ResultEnums;
import com.sun.provincecenter.exception.ProvinceException;
import com.sun.provincecenter.service.ProvinceService;
import com.sun.provincecenter.util.ResultVOUtil;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * 省份接口
 * @author zcm
 */
@RestController
@RequestMapping("/province")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProvinceController {

    private final ProvinceService provinceService;

    @GetMapping("/{id}")
    public ResultVO<Object> getProvinceById(@PathVariable Integer id){
        if (null == id){
            throw new ProvinceException(ResultEnums.PARAM_ERROR);
        }
        return ResultVOUtil.getSuccess(provinceService.getProvinceById(id));
    }

}
