package com.frontier.records.api.recommend;

import com.frontier.records.api.dto.PageResult;
import com.frontier.records.api.recommend.model.RecommendMusic;
import com.frontier.records.api.recommend.service.RecommendService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SuppressWarnings("CheckStyle")
@RestController
@RequestMapping("/api/recommend")
@RequiredArgsConstructor
public class RecommendRestController {

    private final RecommendService recommendService;

    @GetMapping("/music")
    public PageResult<RecommendMusic> getRecommendCards(Pageable pageable) {
        return new PageResult<>(recommendService.getRecommendMusics(pageable), pageable, recommendService.getRecommendMusicTotalCount());
    }
}
