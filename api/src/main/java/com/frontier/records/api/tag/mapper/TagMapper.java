package com.frontier.records.api.tag.mapper;

import com.frontier.records.api.tag.model.Tag;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface TagMapper {

    List<Tag> selectAutoCompleteTags(@Param("word") String word,
                                     @Param("maxSize") int maxSize);
}
