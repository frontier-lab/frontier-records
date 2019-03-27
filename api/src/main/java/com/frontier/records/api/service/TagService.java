package com.frontier.records.api.service;

import com.frontier.records.api.dto.tag.TagDto;
import com.frontier.records.api.mapper.TagMapper;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@SuppressWarnings("CheckStyle")
@Service
@RequiredArgsConstructor
public class TagService {

    private final TagMapper tagMapper;

    public List<TagDto> getAutoCompleteTags(String word, int maxSize) {
        return tagMapper.selectAutoCompleteTags(word, maxSize).stream()
                        .map(TagDto::create)
                        .collect(Collectors.toList());
    }
}
