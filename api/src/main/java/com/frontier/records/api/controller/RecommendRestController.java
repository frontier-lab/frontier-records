package com.frontier.records.api.controller;

import com.frontier.records.api.dto.recommend.RecommendCard;
import com.frontier.records.api.protocol.ApiResponse;
import com.frontier.records.api.protocol.GetRecommendRequest;
import com.frontier.records.api.protocol.GetRecommendResponse;
import com.frontier.records.api.service.RecommendService;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 추천 영역 API
 * Author : jaeeun.yoo
 */
@SuppressWarnings("CheckStyle")
@RestController
@RequestMapping("/api/recommend")
@RequiredArgsConstructor
public class RecommendRestController {

    private final RecommendService recommendService;

    @ApiOperation(value = "추천 영역 페이지 데이터 조회")
    @PostMapping("/getRecommendCards")
    public ApiResponse<GetRecommendResponse> getRecommendCards(GetRecommendRequest request) {
        List<RecommendCard> cards = recommendService.getRecommendCards(request.getPage());
        return new ApiResponse<>(GetRecommendResponse.create(recommendService.hasNextRecommendCard(request.getPage(), cards.size()), cards));
    }
}
