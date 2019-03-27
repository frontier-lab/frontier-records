package com.frontier.records.api.protocol;

import com.frontier.records.api.dto.music.MusicSummaryDto;
import com.frontier.records.api.util.pagination.Page;
import com.frontier.records.api.util.pagination.Pager;
import java.io.Serializable;
import java.util.List;
import lombok.Getter;
import lombok.ToString;

@SuppressWarnings("CheckStyle")
@ToString
@Getter
public class GetMusicSummariesByTagResponse<T> extends Page<T> implements Serializable {

    private static final long serialVersionUID = 6579562379465735230L;

    private GetMusicSummariesByTagResponse(Pager pager, int total, List<T> content) {
        super(pager, total, content);
    }

    public static GetMusicSummariesByTagResponse create(Pager pager, int total, List<MusicSummaryDto> musicSummaries) {
        return new GetMusicSummariesByTagResponse<>(pager, total, musicSummaries);
    }
}
