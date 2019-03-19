package com.frontier.records.api.music;

import com.frontier.records.api.dto.PageResult;
import com.frontier.records.api.dto.Result;
import com.frontier.records.api.music.model.MusicDetail;
import com.frontier.records.api.music.model.MusicSummary;
import com.frontier.records.api.music.service.MusicService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SuppressWarnings("CheckStyle")
@RestController
@RequestMapping("/api/music")
@RequiredArgsConstructor
public class MusicRestController {

    private final MusicService musicService;

    @GetMapping("/{musicId}")
    public Result<MusicDetail> getMusicDetail(@PathVariable Integer musicId) {
        return new Result<>(musicService.getMusicDetail(musicId));
    }

    @GetMapping("/tag/{tagId}")
    public PageResult<MusicSummary> getMusicSummariesByTag(@PathVariable Integer tagId, Pageable pageable) {
        return new PageResult<>(musicService.getMusicSummariesByTag(tagId, pageable),
                                pageable,
                                musicService.getMusicSummaryTotalCountByTag(tagId));
    }
}
