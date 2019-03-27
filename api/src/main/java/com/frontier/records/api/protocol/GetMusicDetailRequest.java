package com.frontier.records.api.protocol;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class GetMusicDetailRequest {

    @NonNull
    private Integer musicId;
}
