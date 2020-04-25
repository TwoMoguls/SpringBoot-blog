package com.yelv.yelv_blog.mapper;

import com.yelv.yelv_blog.entity.Category;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CategoryMapper {

    @Insert("insert into category values (#{categoryId},#{categoryName})")
    int saveCategory(Category category);

    @Select("select id,name from category where category_id = #{categoryId}")
    Category getCategory(@Param("categoryId") Integer categoryId);

    @Select("select * from Category where category_name = #{categoryName}")
    Category getCategoryByName(@Param("categoryName") String categoryName);

    @Select("select * from category")
    List<Category> getAllCategory();

    List<Category> getArticleCategory();

    @Update("update category set category_name = #{categoryName} where category_id = #{categoryId};")
    int updateCategory(Category category);

    @Delete("delete from category where category_id = #{categoryId}")
    int deleteCategory(@Param("categoryId") Integer categoryId);
}
