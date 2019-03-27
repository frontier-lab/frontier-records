package com.frontier.records.api.model;

import java.io.Serializable;
import lombok.Data;

@Data
public class MusicSummary implements Serializable {

    private static final long serialVersionUID = -4L;

    private Integer musicId;
    private String musicTitle;
    private String musicUrl;
    private String musicImage;
    private String artistName;
    private String artistImage;
}
