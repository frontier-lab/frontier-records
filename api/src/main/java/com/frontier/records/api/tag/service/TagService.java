package com.frontier.records.api.tag.service;

import com.frontier.records.api.tag.mapper.TagMapper;
import com.frontier.records.api.tag.model.Tag;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TagService {

    private final TagMapper tagMapper;

    public List<Tag> getAutoCompleteTags(String word, int maxSize) {
        return tagMapper.selectAutoCompleteTags(word, maxSize);
    }
}
