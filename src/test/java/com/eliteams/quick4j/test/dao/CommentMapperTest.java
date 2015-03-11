package com.eliteams.quick4j.test.dao;

import com.eliteams.quick4j.core.feature.test.TestSupport;
import com.eliteams.quick4j.web.dao.CommentMapper;
import com.eliteams.quick4j.web.dao.QiugouMapper;
import com.eliteams.quick4j.web.model.Comment;
import com.eliteams.quick4j.web.model.Qiugou;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

public class CommentMapperTest extends TestSupport {
    @Resource
    private CommentMapper commentMapper;

    @Test
    public void test_selectByDate() {
        start();
        List<Comment> comments = commentMapper.selectByDate("2015-02-10 00:00:00",
                                                         "2015-04-10 00:00:00");
        for (Comment comment : comments) {
            System.err.println(comment.getId());
        }
        end();
    }
}
