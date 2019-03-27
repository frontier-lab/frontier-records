package com.frontier.records.api.protocol;

import com.frontier.records.api.util.pagination.Pager;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class GetMusicCommentsRequest extends Pager {

    @NonNull
    private Integer musicId;
}
