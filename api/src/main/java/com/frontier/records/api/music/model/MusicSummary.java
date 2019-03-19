package com.frontier.records.api.music.model;

import lombok.Data;

@SuppressWarnings("CheckStyle")
@Data
public class MusicSummary {

    private Integer musicId;

    private String musicTitle;

    private String musicUrl;

    private String musicImage;

    private String artistName;

    private String artistImage;
}
