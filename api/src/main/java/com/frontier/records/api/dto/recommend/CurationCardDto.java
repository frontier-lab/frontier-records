package com.frontier.records.api.dto.recommend;

import java.io.Serializable;
import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@SuppressWarnings("CheckStyle")
@ToString
@Getter
@Setter(AccessLevel.PRIVATE)
public class CurationCardDto implements RecommendCard, Serializable {

    private static final long serialVersionUID = 1073348917143109479L;

    private RecommendCardType cardType = RecommendCardType.CURATION;

    private String curationTitle;

    private List<CurationItemDto> items;

    public int getSize() {
        return this.items.size();
    }

    public static CurationCardDto create(String curationTitle, List<CurationItemDto> curationItems) {
        CurationCardDto curationCard = new CurationCardDto();
        curationCard.curationTitle = curationTitle;
        curationCard.items = curationItems;
        return curationCard;
    }
}
