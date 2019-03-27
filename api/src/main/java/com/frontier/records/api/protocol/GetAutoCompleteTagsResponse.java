package com.frontier.records.api.protocol;

import com.frontier.records.api.dto.tag.TagDto;
import java.io.Serializable;
import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@SuppressWarnings("CheckStyle")
@ToString
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class GetAutoCompleteTagsResponse implements Serializable {

    private static final long serialVersionUID = 3764573286956252522L;

    private List<TagDto> tags;

    public static GetAutoCompleteTagsResponse create(List<TagDto> tags) {
        return new GetAutoCompleteTagsResponse(tags);
    }
}
