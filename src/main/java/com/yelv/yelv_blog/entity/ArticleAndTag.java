package com.yelv.yelv_blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleAndTag {

    private Integer articleId;

    private  Integer tagId;
}
