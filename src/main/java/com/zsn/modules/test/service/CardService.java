package com.zsn.modules.test.service;

import com.zsn.modules.test.pojo.Card;
import com.zsn.modules.test.pojo.Result;

public interface CardService {

    Result<Card> insertCard(Card card);

}
