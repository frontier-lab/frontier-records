package com.frontier.records.api.recommend.model;

import lombok.Data;

@SuppressWarnings("CheckStyle")
@Data
public class RecommendMusic implements RecommendCard {

    private Integer musicId;

    private String musicTitle;

    private String musicUrl;

    private String musicImage;

    private int runningTime;

    private int playCount;

    private Integer artistId;

    private String artistName;

    private String artistImage;

    private int totalLikeCount;
}
