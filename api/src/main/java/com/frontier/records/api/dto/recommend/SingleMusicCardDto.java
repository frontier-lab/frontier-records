package com.frontier.records.api.dto.recommend;

import com.frontier.records.api.model.Music;
import java.io.Serializable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@SuppressWarnings("CheckStyle")
@ToString
@Getter
@Setter(AccessLevel.PRIVATE)
public class SingleMusicCardDto implements RecommendCard, Serializable {

    private static final long serialVersionUID = 8173348917143109479L;

    private RecommendCardType cardType = RecommendCardType.MUSIC;

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

    public static SingleMusicCardDto create(Music music) {
        SingleMusicCardDto singleMusicCard = new SingleMusicCardDto();
        singleMusicCard.musicId = music.getMusicId();
        singleMusicCard.musicTitle = music.getMusicTitle();
        singleMusicCard.musicUrl = music.getMusicUrl();
        singleMusicCard.musicImage = music.getMusicImage();
        singleMusicCard.runningTime = music.getRunningTime();
        singleMusicCard.playCount = music.getPlayCount();
        singleMusicCard.artistId = music.getArtistId();
        singleMusicCard.artistName = music.getArtistName();
        singleMusicCard.artistImage = music.getArtistImage();
        singleMusicCard.totalLikeCount = music.getTotalLikeCount();
        return singleMusicCard;
    }
}
