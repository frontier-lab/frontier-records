package com.frontier.records.api.protocol;

import com.frontier.records.api.dto.recommend.RecommendCard;
import java.io.Serializable;
import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@SuppressWarnings("CheckStyle")
@ToString
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class GetRecommendResponse implements Serializable {

    private static final long serialVersionUID = 3532896925751513523L;

    private boolean hasMore;
    private List<RecommendCard> cards;

    public static GetRecommendResponse create(boolean hasMore, List<RecommendCard> cards) {
        return new GetRecommendResponse(hasMore, cards);
    }
}
