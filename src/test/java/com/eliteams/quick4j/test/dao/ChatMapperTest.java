package com.eliteams.quick4j.test.dao;

import com.eliteams.quick4j.core.feature.test.TestSupport;
import com.eliteams.quick4j.web.dao.ChatMapper;
import com.eliteams.quick4j.web.dao.ReportMapper;
import com.eliteams.quick4j.web.model.Chat;
import com.eliteams.quick4j.web.model.Report;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

public class ChatMapperTest extends TestSupport {
    @Resource
    private ChatMapper mapper;

    @Test
    public void test_selectByDate() {
        start();
        List<Chat> results = mapper.selectByDate("2015-02-10 00:00:00",
                                                         "2015-04-10 00:00:00");
        for (Chat item : results) {
            System.err.println(item.getId());
        }
        end();
    }
}
