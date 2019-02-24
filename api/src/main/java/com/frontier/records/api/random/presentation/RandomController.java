package com.frontier.records.api.random.presentation;

import com.frontier.records.api.random.application.RandomService;
import com.frontier.records.api.random.dto.RandomMusic;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SuppressWarnings("CheckStyle")
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class RandomController {

    private final RandomService randomService;

    @RequestMapping(value = "/random", method = {RequestMethod.GET, RequestMethod.POST})
    public PageImpl<RandomMusic> getRandomMusics(@PageableDefault(size = 2) Pageable pageable) {
        return randomService.getRandomMusic(pageable);
    }
}
