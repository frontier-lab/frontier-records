package com.frontier.records.api.dto.music;

import com.frontier.records.api.model.MusicSummary;
import java.io.Serializable;
import lombok.Getter;
import lombok.ToString;

@SuppressWarnings("CheckStyle")
@ToString
@Getter
public class MusicSummaryDto implements Serializable {

    private static final long serialVersionUID = 8073348917149709479L;

    private Integer musicId;
    private String musicTitle;
    private String musicUrl;
    private String musicImage;
    private String artistName;
    private String artistImage;

    public static MusicSummaryDto create(MusicSummary musicSummary) {
        MusicSummaryDto musicSummaryDto = new MusicSummaryDto();
        musicSummaryDto.musicId = musicSummary.getMusicId();
        musicSummaryDto.musicTitle = musicSummary.getMusicTitle();
        musicSummaryDto.musicUrl = musicSummary.getMusicUrl();
        musicSummaryDto.musicImage = musicSummary.getMusicImage();
        musicSummaryDto.artistName = musicSummary.getArtistName();
        musicSummaryDto.artistImage = musicSummary.getArtistImage();
        return musicSummaryDto;
    }
}
