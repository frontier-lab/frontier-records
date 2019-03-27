package com.frontier.records.api.dto.recommend;

import java.io.Serializable;

public class ArtistCardDto implements RecommendCard, Serializable {

    private static final long serialVersionUID = 8073348913113139479L;

    private RecommendCardType cardType = RecommendCardType.ARTIST;
}
