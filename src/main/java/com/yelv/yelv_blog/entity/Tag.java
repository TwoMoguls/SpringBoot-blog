package com.yelv.yelv_blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 博客标签
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tag {

    private Integer tagId;

    private String tagName;

}
