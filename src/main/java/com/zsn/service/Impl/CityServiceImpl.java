package com.zsn.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zsn.mapper.CityMapper;
import com.zsn.pojo.City;
import com.zsn.pojo.SearchVo;
import com.zsn.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class CityServiceImpl implements CityService {
    @Autowired
    CityMapper cityMapper;
    @Override
    public List<City> getCityByCountryId(int countryId) {
//        Optional
//                .ofNullable(cityDao.getCitiesByCountryId(countryId))
//                .orElse(Collections.emptyList());
        return Optional.
                ofNullable(cityMapper.getCityByCountryId(countryId)).
                orElse(Collections.emptyList());
    }
    public PageInfo<City> PageInfoCity(int countryId, SearchVo searchVo){
        PageHelper.startPage(searchVo.getCurrentPage(),searchVo.getPageSize());


        return new PageInfo<City>(
                Optional.ofNullable(cityMapper.getCityByCountryId(countryId))
                        .orElse(Collections.emptyList()));


    }

}
