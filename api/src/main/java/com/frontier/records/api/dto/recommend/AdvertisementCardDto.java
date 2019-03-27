package com.frontier.records.api.dto.recommend;

import java.io.Serializable;

public class AdvertisementCardDto implements RecommendCard, Serializable {

    private static final long serialVersionUID = 8073348917143109479L;

    private RecommendCardType cardType = RecommendCardType.ADVERTISEMENT;
}
