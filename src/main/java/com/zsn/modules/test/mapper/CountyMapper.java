package com.zsn.modules.test.mapper;

import com.zsn.modules.test.pojo.Country;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CountyMapper {

    @Select("select * from m_country where country_id=#{countyId}")
    @Results(id = "countryResults", value = {
            @Result(column = "country_id", property = "countryId"),
            @Result(column = "country_id", property = "cities",
                    javaType = List.class,
                    many = @Many(select =
                            "com.zsn.mapper.CityMapper.getCityByCountryId"))
    })
    Country getCountryByCountyId(int countyId);

    @Select("select * from m_country where country_name=#{countryName}")
    @ResultMap(value = "countryResults")
    Country getCountryByCountryName(String countryName);

    @Select("select * from m_country where country_id=#{countryId}")
    Country getCountryByRedis(int countryId);
}
