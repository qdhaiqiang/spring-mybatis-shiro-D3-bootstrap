package com.eliteams.quick4j.test.dao;

import com.eliteams.quick4j.core.feature.test.TestSupport;
import com.eliteams.quick4j.web.dao.CommentMapper;
import com.eliteams.quick4j.web.dao.ReportMapper;
import com.eliteams.quick4j.web.model.Comment;
import com.eliteams.quick4j.web.model.Report;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

public class ReportMapperTest extends TestSupport {
    @Resource
    private ReportMapper mapper;

    @Test
    public void test_selectByDate() {
        start();
        List<Report> result = mapper.selectByDate("2015-02-10 00:00:00",
                                                         "2015-04-10 00:00:00");
        for (Report report : result) {
            System.err.println(report.getId());
        }
        end();
    }
}
