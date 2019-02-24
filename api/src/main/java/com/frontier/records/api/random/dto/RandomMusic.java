package com.frontier.records.api.random.dto;

import com.frontier.records.api.music.model.LikeMoment;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RandomMusic {

    private Long musicId;
    private String musicUrl;
    private String musicTitle;
    private String musicImage;
    private Long artistId;
    private String artistName;
    private String lyrics;
    private int runningMilliSeconds;
    private List<LikeMoment> likeMoments;
}
