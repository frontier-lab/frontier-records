package com.frontier.records.api.music;

import com.frontier.records.api.dto.PageResult;
import com.frontier.records.api.dto.Result;
import com.frontier.records.api.music.model.MusicDetail;
import com.frontier.records.api.music.model.MusicSummary;
import com.frontier.records.api.music.service.MusicService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SuppressWarnings("CheckStyle")
@RestController
@RequestMapping("/api/music")
@RequiredArgsConstructor
public class MusicRestController {

    private final MusicService musicService;

    @ApiOperation(value = "음악 상세 조회", notes = "runningTime의 단위는 milli sec")
    @GetMapping("/{musicId}")
    public Result<MusicDetail> getMusicDetail(@PathVariable Integer musicId) {
        return new Result<>(musicService.getMusicDetail(musicId));
    }

    @ApiOperation(value = "해시태그 음악 검색")
    @GetMapping("/tag/{tagId}")
    public PageResult<MusicSummary> getMusicSummariesByTag(@PathVariable Integer tagId, Pageable pageable) {
        return new PageResult<>(musicService.getMusicSummariesByTag(tagId, pageable),
                                pageable,
                                musicService.getMusicSummaryTotalCountByTag(tagId));
    }

    @ApiOperation(value = "음악 재생 수 증가", notes = "음악 재생 시 호출")
    @PutMapping("/{musicId}/play-count")
    public Result<Object> putMusicPlayCount(@PathVariable Integer musicId) {
        musicService.putMusicPlayCount(musicId);
        return new Result<>(null);
    }
}
