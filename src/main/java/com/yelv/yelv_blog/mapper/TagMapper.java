package com.yelv.yelv_blog.mapper;

import com.yelv.yelv_blog.entity.Tag;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TagMapper {

    @Insert("insert into tag values (#{tagId},#{tagName})")
    int saveTag(Tag tag);

    @Select("select id,name from tag where tag_id = #{tagId}")
    Tag getTag(@Param("tagId") Integer tagId);

    @Select("select * from tag where tag_name = #{tagName}")
    Tag getTagByName(@Param("tagName") String tagName);

    @Select("select * from tag")
    List<Tag> getAllTags();

    @Update("update tag set tag_name = #{tagName} where tag_id = #{tagId};")
    int updateTag(Tag tag);

    @Delete("delete from tag where tag_id = #{tagId}")
    void deleteTag(@Param("tagId") Integer tagId);

    List<Tag> getArticleTag();
}
