package com.frontier.records.api.music.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.frontier.records.api.tag.model.Tag;
import java.time.ZonedDateTime;
import java.util.List;
import lombok.Data;

@SuppressWarnings("CheckStyle")
@Data
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
public class MusicDetail {

    private Integer musicId;

    private String musicTitle;

    private String lyrics;

    private String musicUrl;

    private String musicImage;

    private long runningTime;

    private boolean disabled;

    private boolean deleted;

    @JsonIgnore
    private ZonedDateTime registerDateTime;

    @JsonIgnore
    private ZonedDateTime modifyDateTime;

    private Integer artistId;

    private String artistName;

    private String artistImage;

    private int totalLikeCount;

    private List<LikeMoment> likeMoments;

    private List<Tag> tags;
}
