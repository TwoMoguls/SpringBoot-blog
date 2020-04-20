package com.yelv.yelv_blog;

import com.yelv.yelv_blog.mapper.TypeRepository;
import com.yelv.yelv_blog.service.TypeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;

@SpringBootTest
class YelvBlogApplicationTests {
    @Autowired
    TypeService typeService;
    @Test
    void contextLoads(@PageableDefault(size = 8, sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable) {
        System.out.println(typeService.listType(pageable));
    }

}
