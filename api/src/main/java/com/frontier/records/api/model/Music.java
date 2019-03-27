package com.frontier.records.api.model;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.List;
import lombok.Data;

@Data
public class Music implements Serializable {

    private static final long serialVersionUID = -2L;

    private Integer musicId;
    private String musicTitle;
    private String lyrics;
    private String musicUrl;
    private String musicImage;
    private int runningTime;
    private int viewCount;
    private int playCount;
    private boolean disabled;
    private boolean deleted;
    private ZonedDateTime registerDateTime;
    private ZonedDateTime modifyDateTime;
    private Integer artistId;
    private String artistName;
    private String artistImage;
    private int totalLikeCount;
    private List<LikeMoment> likeMoments;
    private List<Tag> tags;
}
