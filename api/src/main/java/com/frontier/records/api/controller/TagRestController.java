package com.frontier.records.api.controller;

import com.frontier.records.api.protocol.ApiResponse;
import com.frontier.records.api.protocol.GetAutoCompleteTagsRequest;
import com.frontier.records.api.protocol.GetAutoCompleteTagsResponse;
import com.frontier.records.api.service.TagService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 해시태그 API
 * Author : jaeeun.yoo
 */
@SuppressWarnings("CheckStyle")
@RestController
@RequestMapping("/api/tag")
@RequiredArgsConstructor
public class TagRestController {

    private final TagService tagService;

    @ApiOperation(value = "해시 태그 자동완성")
    @PostMapping("/getAutoCompleteTags")
    public ApiResponse<GetAutoCompleteTagsResponse> getAutoCompleteTags(GetAutoCompleteTagsRequest request) {
        return new ApiResponse<>(GetAutoCompleteTagsResponse.create(tagService.getAutoCompleteTags(request.getWord(), request.getMaxSize())));
    }
}
