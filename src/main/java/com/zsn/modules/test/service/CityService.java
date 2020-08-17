package com.zsn.modules.test.service;

import com.github.pagehelper.PageInfo;
import com.zsn.modules.test.pojo.City;
import com.zsn.modules.test.pojo.Result;
import com.zsn.modules.test.pojo.SearchVo;

import java.util.List;

public interface CityService {
    List<City> getCityByCountryId(int countryId);
    public PageInfo<City> PageInfoCity(int countryId, SearchVo searchVo);
    PageInfo<City> getCityBySearchVo(SearchVo searchVo);

    Result<City> insertCity(City city);
    Result<City> updateCity(City city);
    Result<Object> deletedCity(int cityId);

}
