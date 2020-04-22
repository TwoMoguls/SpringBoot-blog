package com.yelv.yelv_blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 博客类型
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {

    private Integer categoryId;

    private String categoryName;


}
