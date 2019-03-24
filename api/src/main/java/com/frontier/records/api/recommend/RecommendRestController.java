package com.frontier.records.api.recommend;

import com.frontier.records.api.common.dto.PageResult;
import com.frontier.records.api.common.dto.Result;
import com.frontier.records.api.recommend.model.RecommendMusic;
import com.frontier.records.api.recommend.service.RecommendService;
import io.swagger.annotations.ApiOperation;
import java.util.Collections;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

@SuppressWarnings("CheckStyle")
@RestController
@RequestMapping("/api/recommend")
@RequiredArgsConstructor
public class RecommendRestController {

    private final RecommendService recommendService;

    @ApiOperation(value = "Hot And Hew 조회")
    @ApiIgnore(value = "sort")
    @GetMapping("/hot-and-new")
    public Result<List<RecommendMusic>> getHowAndNewMusics() {
        return new Result<>(Collections.emptyList());
    }

    @ApiOperation(value = "최근 음악 조회")
    @GetMapping("/recent")
    public PageResult<RecommendMusic> getRecentMusics(Pageable pageable) {
        return new PageResult<>(recommendService.getRecentMusics(pageable), pageable, recommendService.getRecentMusicTotalCount());
    }
}
