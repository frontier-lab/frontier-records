package com.frontier.records.api.music.service;

import com.frontier.records.api.music.mapper.MusicMapper;
import com.frontier.records.api.music.model.MusicDetail;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MusicService {

    private final MusicMapper musicMapper;

    public MusicDetail getMusicDetail(Integer musicId) {
        return musicMapper.selectOneMusicDetail(musicId);
    }
}
