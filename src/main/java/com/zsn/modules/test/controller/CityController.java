package com.zsn.modules.test.controller;

import com.github.pagehelper.PageInfo;
import com.zsn.modules.test.pojo.City;
import com.zsn.modules.test.pojo.Result;
import com.zsn.modules.test.pojo.SearchVo;
import com.zsn.modules.test.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class CityController {

    @Autowired
    CityService cityService;

    @GetMapping("/city/{countryId}")
    public List<City> getCityByCountryId(@PathVariable int countryId) {

        return cityService.getCityByCountryId(countryId);
    }

    //* 127.0.0.1/api/cities/522 --- post
//*{"currentPage":"1","pageSize":"5"}
    @PostMapping(value = "cities/{countryId}", consumes = "application/json")
    public PageInfo<City> PageInfoCity(@PathVariable int countryId, @RequestBody SearchVo searchVo) {

        return cityService.PageInfoCity(countryId, searchVo);
    }
    /*
    * 127.0.0.1/api/cities
    * {"currentPage":"1","pageSize":"5","keyWord":"sh","orderBy":"city_id","sort":"desc"}
    * */
    @GetMapping(value = "/cities",consumes = "application/json")
    public PageInfo<City> getCityBySearchVo(@RequestBody SearchVo searchVo){

        return cityService.getCityBySearchVo(searchVo);
    }
    @PostMapping(value = "city",consumes = "application/json")
    public Result<City> insertCity(@RequestBody City city){
        return cityService.insertCity(city);
    }
    @PutMapping(value = "city",consumes = "application/x-www-form-urlencoded")
    public Result<City> updateCity(@ModelAttribute City city){
        return cityService.updateCity(city);
    }
    @DeleteMapping(value = "city/{cityId}")
    public Result<Object> deletedCity(@PathVariable("cityId") int cityId){
        return cityService.deletedCity(cityId);
    }

}
