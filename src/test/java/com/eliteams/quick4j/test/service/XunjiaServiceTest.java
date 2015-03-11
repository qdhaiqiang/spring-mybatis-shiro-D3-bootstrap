package com.eliteams.quick4j.test.service;

import com.eliteams.quick4j.core.feature.test.TestSupport;
import com.eliteams.quick4j.core.util.ApplicationUtils;
import com.eliteams.quick4j.web.model.User;
import com.eliteams.quick4j.web.model.Xunjia;
import com.eliteams.quick4j.web.service.UserService;
import com.eliteams.quick4j.web.service.XunjiaService;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

public class XunjiaServiceTest extends TestSupport {

    @Resource
    private XunjiaService xunjiaService;

    @Test
    public void test_select() {
        List<Xunjia> xunjias = xunjiaService.selectByDate("2015-02-10 00:00:00",
                "2015-02-12 00:00:00");
        for (Xunjia xunjia : xunjias) {
            System.err.println(xunjia.getDate());
        }
    }
}
