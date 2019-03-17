package com.frontier.records.api.recommend.model;

import lombok.Data;

@SuppressWarnings("CheckStyle")
@Data
public class RecommendMusic implements RecommendCard {

    private Integer musicId;
    private String musicTitle;
    private String musicUrl;
    private String musicImage;
    private long runningTime;

    private Integer artistId;
    private String artistName;

    private int totalLikeCount;
}
