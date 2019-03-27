package com.frontier.records.api.controller;

import com.frontier.records.api.protocol.ApiResponse;
import com.frontier.records.api.protocol.GetMusicDetailRequest;
import com.frontier.records.api.protocol.GetMusicDetailResponse;
import com.frontier.records.api.protocol.GetMusicSummariesByTagRequest;
import com.frontier.records.api.protocol.GetMusicSummariesByTagResponse;
import com.frontier.records.api.protocol.PutMusicCountRequest;
import com.frontier.records.api.service.MusicService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 음악 도메인 관련 앱 API
 * Author : jaeeun.yoo
 */
@SuppressWarnings("CheckStyle")
@RestController
@RequestMapping("/api/music")
@RequiredArgsConstructor
public class MusicRestController {

    private final MusicService musicService;

    @ApiOperation(value = "음악 상세 조회", notes = "runningTime의 단위는 milli sec")
    @PostMapping("/getMusicDetail")
    public ApiResponse<GetMusicDetailResponse> getMusicDetail(GetMusicDetailRequest request) {
        return new ApiResponse<>(GetMusicDetailResponse.create(musicService.getMusicDetail(request.getMusicId())));
    }

    @ApiOperation(value = "해시태그 음악 검색")
    @PostMapping("/getMusicSummariesByTag")
    public ApiResponse<GetMusicSummariesByTagResponse> getMusicSummariesByTag(GetMusicSummariesByTagRequest request) {
        return new ApiResponse<>(GetMusicSummariesByTagResponse.create(request,
                                                                       musicService.getMusicSummaryTotalCountByTag(request.getTagId()),
                                                                       musicService.getMusicSummariesByTag(request.getTagId(), request)));
    }

    @ApiOperation(value = "음악 재생 수 증가", notes = "음악 재생 시 호출")
    @PostMapping("/putMusicPlayCount")
    public ApiResponse putMusicPlayCount(PutMusicCountRequest request) {
        musicService.putMusicPlayCount(request.getMusicId());
        return ApiResponse.EMPTY;
    }

    @ApiOperation(value = "음악 조회 수 증가", notes = "음악 상세화면 진입 시 호출")
    @PostMapping("/putMusicViewCount")
    public ApiResponse putMusicViewCount(PutMusicCountRequest request) {
        musicService.putMusicViewCount(request.getMusicId());
        return ApiResponse.EMPTY;
    }
}
