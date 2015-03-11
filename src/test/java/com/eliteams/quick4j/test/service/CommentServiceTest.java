package com.eliteams.quick4j.test.service;

import com.eliteams.quick4j.core.feature.test.TestSupport;
import com.eliteams.quick4j.web.model.Comment;
import com.eliteams.quick4j.web.model.Xunjia;
import com.eliteams.quick4j.web.service.CommentService;
import com.eliteams.quick4j.web.service.XunjiaService;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

public class CommentServiceTest extends TestSupport {

    @Resource
    private CommentService commentService;

    @Test
    public void test_select() {
        List<Comment> comments = commentService.selectByDate("2015-02-10 00:00:00",
                "2015-02-12 00:00:00");
        for (Comment comment : comments) {
            System.err.println(comment.getDate());
        }
    }
}
