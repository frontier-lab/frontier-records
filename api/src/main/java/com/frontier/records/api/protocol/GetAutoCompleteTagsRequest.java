package com.frontier.records.api.protocol;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class GetAutoCompleteTagsRequest {

    @NonNull
    private String word;

    private int maxSize;
}
