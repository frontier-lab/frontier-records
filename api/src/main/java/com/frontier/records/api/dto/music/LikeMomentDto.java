package com.frontier.records.api.dto.music;

import com.frontier.records.api.model.LikeMoment;
import java.io.Serializable;
import lombok.Getter;
import lombok.ToString;

@SuppressWarnings("CheckStyle")
@ToString
@Getter
public class LikeMomentDto implements Serializable {

    private static final long serialVersionUID = 8073348917143707479L;

    private int moment;
    private int likeCount;

    public static LikeMomentDto create(LikeMoment likeMoment) {
        LikeMomentDto likeMomentDto = new LikeMomentDto();
        likeMomentDto.moment = likeMoment.getMoment();
        likeMomentDto.likeCount = likeMoment.getLikeCount();
        return likeMomentDto;
    }
}
