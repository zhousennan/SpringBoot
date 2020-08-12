package com.zsn.service;

import com.zsn.pojo.Card;
import com.zsn.pojo.Result;

public interface CardService {

    Result<Card> insertCard(Card card);

}
