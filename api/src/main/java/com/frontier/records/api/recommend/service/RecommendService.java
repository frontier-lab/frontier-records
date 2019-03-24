package com.frontier.records.api.recommend.service;

import com.frontier.records.api.recommend.mapper.RecommendMapper;
import com.frontier.records.api.recommend.model.RecommendMusic;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@SuppressWarnings("CheckStyle")
@Service
@RequiredArgsConstructor
public class RecommendService {

    private final RecommendMapper recommendMapper;

    public List<RecommendMusic> getRecentMusics(Pageable pageable) {
        return recommendMapper.selectAllRecentMusics(pageable.getOffset(), pageable.getPageSize());
    }

    public long getRecentMusicTotalCount() {
        return recommendMapper.selectRecentMusicTotalCount();
    }
}
