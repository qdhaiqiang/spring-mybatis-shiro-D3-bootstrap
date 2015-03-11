package com.eliteams.quick4j.test.service;

import com.eliteams.quick4j.core.feature.test.TestSupport;
import com.eliteams.quick4j.web.model.Chat;
import com.eliteams.quick4j.web.model.Report;
import com.eliteams.quick4j.web.service.ChatService;
import com.eliteams.quick4j.web.service.ReportService;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

public class ChatServiceTest extends TestSupport {

    @Resource
    private ChatService service;

    @Test
    public void test_select() {
        List<Chat> result = service.selectByDate("2015-02-10 00:00:00",
                "2015-03-12 00:00:00");
        for (Chat item : result) {
            System.err.println(item.getDate());
        }
    }
}
