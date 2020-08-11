package com.zsn.controller;

import com.github.pagehelper.PageInfo;
import com.zsn.pojo.City;
import com.zsn.pojo.SearchVo;
import com.zsn.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class CityController {

    @Autowired
    CityService cityService;
    @GetMapping("/city/{countryId}")
    public List<City> getCityByCountryId(@PathVariable int countryId){

        return cityService.getCityByCountryId(countryId);
    }
//* 127.0.0.1/api/cities/522 --- post
//     *{"currentPage":"1","pageSize":"5"}
    @PostMapping(value = "cities/{countryId}",consumes = "application/json")
    public PageInfo<City> PageInfoCity(@PathVariable int countryId,@RequestBody SearchVo searchVo){

        return cityService.PageInfoCity(countryId,searchVo);
    }
}
