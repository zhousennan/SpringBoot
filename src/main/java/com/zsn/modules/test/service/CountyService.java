package com.zsn.modules.test.service;

import com.zsn.modules.test.pojo.Country;

public interface CountyService {
    Country getCountryByCountyId(int countyId);
    Country getCountryByCountryName(String countryName);
    Country getCountryByRedis(int countryId);
}
