package com.zsn.modules.test.controller;

import com.zsn.modules.test.pojo.Card;
import com.zsn.modules.test.pojo.Result;
import com.zsn.modules.test.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CardController {
    @Autowired
    CardService cardService;
    /**
     * 127.0.0.1/api/card ---- post
     * {"cardNo":"cdascdas687dsa78"}
     */
    @PostMapping(value = "card" ,consumes = "application/json")
    public Result<Card> insertCard(@RequestBody Card card){
        return cardService.insertCard(card);
    }

}
