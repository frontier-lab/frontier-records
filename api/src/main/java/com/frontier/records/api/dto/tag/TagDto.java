package com.frontier.records.api.dto.tag;

import com.frontier.records.api.model.Tag;
import java.io.Serializable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@SuppressWarnings("CheckStyle")
@ToString
@Getter
@Setter(AccessLevel.PRIVATE)
public class TagDto implements Serializable {

    private static final long serialVersionUID = 7073348917143100219L;

    private Integer tagId;

    private String tagName;

    public static TagDto create(Tag tag) {
        TagDto tagDto = new TagDto();
        tagDto.setTagId(tag.getTagId());
        tagDto.setTagName(tag.getTagName());
        return tagDto;
    }
}