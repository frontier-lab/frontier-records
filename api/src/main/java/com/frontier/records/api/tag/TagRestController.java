package com.frontier.records.api.tag;

import com.frontier.records.api.common.dto.Result;
import com.frontier.records.api.tag.model.Tag;
import com.frontier.records.api.tag.service.TagService;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SuppressWarnings("CheckStyle")
@RestController
@RequestMapping("/api/tag")
@RequiredArgsConstructor
public class TagRestController {

    private final TagService tagService;

    @ApiOperation(value = "해시 태그 자동완성")
    @GetMapping("/auto-complete/{word}")
    public Result<List<Tag>> getAutoCompleteTags(
        @PathVariable("word") String word,
        @RequestParam(value = "maxSize", required = true, defaultValue = "5") int maxSize) {
        return new Result<>(tagService.getAutoCompleteTags(word, maxSize));
    }
}
