package com.zsn.mapper;

import com.zsn.pojo.City;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CityMapper {
    @Select("select * from m_city where country_id=#{countryId} ")
    List<City> getCityByCountryId(int countryId);
}
