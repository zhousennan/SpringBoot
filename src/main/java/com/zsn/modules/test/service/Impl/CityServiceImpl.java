package com.zsn.modules.test.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.zsn.aspect.ServiceAnnotation;
import com.zsn.modules.test.mapper.CityMapper;
import com.zsn.modules.test.pojo.City;
import com.zsn.modules.test.pojo.Result;
import com.zsn.modules.test.pojo.SearchVo;
import com.zsn.modules.test.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class CityServiceImpl implements CityService {
    @Autowired
    CityMapper cityMapper;

    @Override
    @ServiceAnnotation
    public List<City> getCityByCountryId(int countryId) {
//        Optional
//                .ofNullable(cityDao.getCitiesByCountryId(countryId))
//                .orElse(Collections.emptyList());
        return Optional.
                ofNullable(cityMapper.getCityByCountryId(countryId)).
                orElse(Collections.emptyList());
    }

    public PageInfo<City> PageInfoCity(int countryId, SearchVo searchVo) {
        PageHelper.startPage(searchVo.getCurrentPage(), searchVo.getPageSize());
        return new PageInfo<City>(
                Optional.ofNullable(cityMapper.getCityByCountryId(countryId))
                        .orElse(Collections.emptyList()));
    }

    @Override
    public PageInfo<City> getCityBySearchVo(SearchVo searchVo) {
        PageHelper.startPage(searchVo.getCurrentPage(), searchVo.getPageSize());

        return new PageInfo<City>(Optional.ofNullable(cityMapper.getCityBySearchVo(searchVo)).orElse(Collections.emptyList()));
    }

    @Override
    public Result<City> insertCity(City city) {
        cityMapper.insertCity(city);
        return new Result<City>(Result.ResultStatus.SUCCESS.status, "insert success.", city);
    }

    @Override
    public Result<City> updateCity(City city) {
        cityMapper.updateCity(city);
        return new Result<>(Result.ResultStatus.SUCCESS.status, "update success.", city);
    }

    @Override
    public Result<Object> deletedCity(int cityId) {
        cityMapper.deletedCity(cityId);
        return new Result<Object>(Result.ResultStatus.SUCCESS.status, "deleted success");
    }

}
