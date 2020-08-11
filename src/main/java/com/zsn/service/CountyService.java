package com.zsn.service;

import com.zsn.pojo.Country;

public interface CountyService {
    Country getCountryByCountyId(int countyId);
    Country getCountryByCountryName(String countryName);
}
