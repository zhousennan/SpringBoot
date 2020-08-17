package com.zsn.modules.test.service.Impl;

import com.zsn.modules.test.mapper.CountyMapper;
import com.zsn.modules.test.pojo.Country;
import com.zsn.modules.test.service.CountyService;
import com.zsn.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CountyServiceImpl implements CountyService {
    @Autowired
    CountyMapper countyMapper;
   @Autowired
   RedisUtils redisUtils;
    @Override
    public Country getCountryByCountyId(int countyId) {
        return countyMapper.getCountryByCountyId(countyId);
    }

    @Override
    public Country getCountryByCountryName(String countryName) {
        return Optional.ofNullable(countyMapper.getCountryByCountryName(countryName))
                .orElse(null);
    }

    @Override
    public Country getCountryByRedis(int countryId) {
        Country country=countyMapper.getCountryByRedis(countryId);
        redisUtils.set("country",country);

        return country;
    }
}
