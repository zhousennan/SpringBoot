package com.zsn.modules.test.service.Impl;

import com.zsn.modules.test.pojo.Card;
import com.zsn.modules.test.pojo.Result;
import com.zsn.modules.test.repository.CardRepository;
import com.zsn.modules.test.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardServiceImpl implements CardService {
    @Autowired
    CardRepository cardRepository;
    @Override
    public Result<Card> insertCard(Card card) {
        cardRepository.saveAndFlush(card);

        return new Result<Card>(Result.ResultStatus.SUCCESS.status,"insert success",card);
    }
}
