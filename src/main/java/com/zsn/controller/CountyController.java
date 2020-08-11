package com.zsn.controller;

import com.zsn.pojo.Country;
import com.zsn.service.CountyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

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

}
