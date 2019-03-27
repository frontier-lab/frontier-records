package com.frontier.records.api.protocol;

import com.frontier.records.api.dto.music.MusicDto;
import java.io.Serializable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@SuppressWarnings("CheckStyle")
@ToString
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class GetMusicDetailResponse implements Serializable {

    private static final long serialVersionUID = 4356728569265729115L;

    private MusicDto music;

    public static GetMusicDetailResponse create(MusicDto music) {
        return new GetMusicDetailResponse(music);
    }
}
