package com.frontier.records.api.dto.music;

import com.frontier.records.api.dto.tag.TagDto;
import com.frontier.records.api.model.Music;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Getter;
import lombok.ToString;

@SuppressWarnings("CheckStyle")
@ToString
@Getter
public class MusicDto implements Serializable {

    private static final long serialVersionUID = 8073318917149707479L;

    private Integer musicId;
    private String musicTitle;
    private String lyrics;
    private String musicUrl;
    private String musicImage;
    private int runningTime;
    private int viewCount;
    private int playCount;
    private Integer artistId;
    private String artistName;
    private String artistImage;
    private int totalLikeCount;
    private List<LikeMomentDto> likeMoments;
    private List<TagDto> tags;

    public static MusicDto create(Music music) {
        MusicDto musicDto = new MusicDto();
        musicDto.musicId = music.getMusicId();
        musicDto.musicTitle = music.getMusicTitle();
        musicDto.lyrics = music.getLyrics();
        musicDto.musicUrl = music.getMusicUrl();
        musicDto.musicImage = music.getMusicImage();
        musicDto.runningTime = music.getRunningTime();
        musicDto.viewCount = music.getViewCount();
        musicDto.playCount = music.getPlayCount();
        musicDto.artistId = music.getArtistId();
        musicDto.artistName = music.getArtistName();
        musicDto.artistImage = music.getArtistImage();
        musicDto.totalLikeCount = music.getTotalLikeCount();
        musicDto.likeMoments = music.getLikeMoments()
                                    .stream()
                                    .map(LikeMomentDto::create)
                                    .collect(Collectors.toList());
        musicDto.tags = music.getTags()
                             .stream()
                             .map(TagDto::create)
                             .collect(Collectors.toList());
        return musicDto;
    }
}
