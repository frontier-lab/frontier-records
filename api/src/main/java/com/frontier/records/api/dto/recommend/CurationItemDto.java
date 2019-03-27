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
public class CurationItemDto implements Serializable {

    private static final long serialVersionUID = 8073348352549709479L;

    private Integer musicId;

    private String musicTitle;

    private String musicUrl;

    private String musicImage;

    private String artistName;

    public static CurationItemDto create(Music music) {
        CurationItemDto curationItem = new CurationItemDto();
        curationItem.musicId = music.getMusicId();
        curationItem.musicTitle = music.getMusicTitle();
        curationItem.musicUrl = music.getMusicUrl();
        curationItem.musicImage = music.getMusicImage();
        curationItem.artistName = music.getArtistName();
        return curationItem;
    }
}
