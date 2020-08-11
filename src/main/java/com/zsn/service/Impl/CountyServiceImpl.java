package com.zsn.service.Impl;

import com.zsn.mapper.CountyMapper;
import com.zsn.pojo.Country;
import com.zsn.service.CountyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.util.Optional;

@Service
public class CountyServiceImpl implements CountyService {
    @Autowired
    CountyMapper countyMapper;

    @Override
    public Country getCountryByCountyId(int countyId) {
        return countyMapper.getCountryByCountyId(countyId);
    }

    @Override
    public Country getCountryByCountryName(String countryName) {
        return Optional.ofNullable(countyMapper.getCountryByCountryName(countryName))
                .orElse(null);
    }
}
