package com.frontier.records.api.random.application;

import com.frontier.records.api.music.model.LikeMoment;
import com.frontier.records.api.random.dto.RandomMusic;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@SuppressWarnings("CheckStyle")
@Service
public class RandomService {

    public PageImpl<RandomMusic> getRandomMusic(Pageable pageable) {
        int totalCount = 20;
        List<RandomMusic> randomMusics = new ArrayList<>();
        for (long i = 0; i < pageable.getPageSize(); i++) {
            randomMusics.add(getMockRandomMusic(i + 1));
        }
        return new PageImpl<>(randomMusics, pageable, totalCount);
    }

    private RandomMusic getMockRandomMusic(long musicId) {
        List<LikeMoment> likeMoments = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            LikeMoment likeMoment = new LikeMoment();
            likeMoment.setLikeCount(1);
            likeMoment.setMilliSecond((i + 1) * 20000);
            likeMoments.add(likeMoment);
        }
        return new RandomMusic(
            musicId,
            "http://www.jaeeunyoo.com/media/sample.mp3",
            "제목제목",
            "http://www.jaeeunyoo.com/image/sample.jpg",
            musicId,
            "무명의 가수",
            "가사가사가사가사가사가사가사가사가사가사가사가사가사가사가사가사가사가사가사가사가사가사가사가사가사가사가사",
            200 * 1000,
            likeMoments
        );
    }
}
