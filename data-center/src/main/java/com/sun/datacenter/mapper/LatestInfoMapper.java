package com.sun.datacenter.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sun.datacenter.entity.LatestInfo;
import org.apache.ibatis.annotations.Select;

/**
 * @author zcm
 */
public interface LatestInfoMapper extends BaseMapper<LatestInfoMapper> {

    /**
     * 获取数据库中最新的一条数据
     * @return 实体
     */
    @Select("select * from latest_info ORDER BY latest_date LIMIT 1")
    public LatestInfo selectLatestInfo();
}
