package com.frontier.records.api.service;

import com.frontier.records.api.dto.music.MusicDto;
import com.frontier.records.api.dto.music.MusicSummaryDto;
import com.frontier.records.api.mapper.MusicMapper;
import com.frontier.records.api.util.pagination.Pager;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@SuppressWarnings("CheckStyle")
@Service
@RequiredArgsConstructor
public class MusicService {

    private final MusicMapper musicMapper;

    public MusicDto getMusicDetail(Integer musicId) {
        return MusicDto.create(musicMapper.selectOneMusicDetail(musicId));
    }

    public List<MusicSummaryDto> getMusicSummariesByTag(Integer tagId, Pager pager) {
        return musicMapper.selectMusicSummariesByTag(tagId, pager.offset(), pager.getSize())
                          .stream()
                          .map(MusicSummaryDto::create)
                          .collect(Collectors.toList());
    }

    public int getMusicSummaryTotalCountByTag(Integer tagId) {
        return musicMapper.getMusicSummaryTotalCountByTag(tagId);
    }

    public void putMusicPlayCount(Integer musicId) {
        musicMapper.updateMusicPlayCount(musicId);
    }

    public void putMusicViewCount(Integer musicId) {
        musicMapper.updateMusicViewCount(musicId);
    }
}
