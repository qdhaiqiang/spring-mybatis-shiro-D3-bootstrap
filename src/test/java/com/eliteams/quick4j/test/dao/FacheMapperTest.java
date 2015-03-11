package com.eliteams.quick4j.test.dao;

import com.eliteams.quick4j.core.feature.test.TestSupport;
import com.eliteams.quick4j.web.dao.CommentMapper;
import com.eliteams.quick4j.web.dao.FacheMapper;
import com.eliteams.quick4j.web.model.Comment;
import com.eliteams.quick4j.web.model.Fache;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

public class FacheMapperTest extends TestSupport {
    @Resource
    private FacheMapper mapper;

    @Test
    public void test_selectByDate() {
        start();
        List<Fache> result = mapper.selectByDate("2015-03-04 00:00:00",
                                                         "2015-03-04 23:00:00");
        for (Fache fache : result) {
            System.err.println(fache.getId());
        }
        end();
    }
}
