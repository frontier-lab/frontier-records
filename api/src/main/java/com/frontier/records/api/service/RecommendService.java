package com.frontier.records.api.service;

import com.frontier.records.api.dto.recommend.CurationCardDto;
import com.frontier.records.api.dto.recommend.CurationItemDto;
import com.frontier.records.api.dto.recommend.RecommendCard;
import com.frontier.records.api.dto.recommend.SingleMusicCardDto;
import com.frontier.records.api.mapper.RecommendMapper;
import com.frontier.records.api.model.Music;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@SuppressWarnings("CheckStyle")
@Service
@RequiredArgsConstructor
public class RecommendService {

    private static final String WEEKLY_HOT_CURATION_TITLE = "Weekly Hot";

    private static final int SIZE_RECENT_MUSIC = 5;
    private static final int SIZE_WEEKLY_HOT_MUSIC = 5;

    private final RecommendMapper recommendMapper;

    public List<RecommendCard> getRecommendCards(int page) {
        List<RecommendCard> recommendCards = new ArrayList<>();
        if (page == 0) {
            recommendCards.add(CurationCardDto.create(WEEKLY_HOT_CURATION_TITLE,
                                                      getWeeklyHotMusics().stream()
                                                                          .map(CurationItemDto::create)
                                                                          .collect(Collectors.toList())));
        }

        recommendCards.addAll(getRecentMusics(page).stream()
                                                   .map(SingleMusicCardDto::create)
                                                   .collect(Collectors.toList()));
        return recommendCards;
    }

    public boolean hasNextRecommendCard(int currentPage, int currentPageSize) {
        return (currentPage * SIZE_RECENT_MUSIC) + currentPageSize < recommendMapper.selectRecentMusicTotalCount();
    }

    private List<Music> getRecentMusics(int page) {
        int startOffset = page * SIZE_RECENT_MUSIC;
        return recommendMapper.selectAllRecentMusics(startOffset, SIZE_RECENT_MUSIC);
    }

    private List<Music> getWeeklyHotMusics() {
        return recommendMapper.selectAllWeeklyHotMusics(SIZE_WEEKLY_HOT_MUSIC);
    }
}
