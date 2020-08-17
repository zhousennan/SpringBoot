package com.zsn.modules.test.controller;

import com.zsn.modules.test.pojo.Country;
import com.zsn.modules.test.service.CountyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CountyController {
    @Autowired
    CountyService countyService;

    @GetMapping("/country/{countryId}")
    public Country getCountryByCountyId(@PathVariable int countryId) {
        return countyService.getCountryByCountyId(countryId);
    }
    /*
    *  127.0.0.1/api/country?countryName=China ---- get
    * */
    @GetMapping("country")
   public Country getCountryByCountryName(@RequestParam String countryName){

        return countyService.getCountryByCountryName(countryName);
    }

    @GetMapping("/countryById/{countryId}")
    public Country getCountryByRedis(@PathVariable(value = "countryId") int countryId) {
        return countyService.getCountryByRedis(countryId);
    }

}
