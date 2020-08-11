package com.zsn.service;

import com.github.pagehelper.PageInfo;
import com.zsn.pojo.City;
import com.zsn.pojo.SearchVo;

import java.util.List;

public interface CityService {
    List<City> getCityByCountryId(int countryId);
    public PageInfo<City> PageInfoCity(int countryId, SearchVo searchVo);
}
