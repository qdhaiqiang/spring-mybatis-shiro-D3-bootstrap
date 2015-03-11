package com.eliteams.quick4j.test.service;

import com.eliteams.quick4j.core.feature.test.TestSupport;
import com.eliteams.quick4j.web.model.Fache;
import com.eliteams.quick4j.web.model.Xunjia;
import com.eliteams.quick4j.web.service.FacheService;
import com.eliteams.quick4j.web.service.XunjiaService;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

public class FacheServiceTest extends TestSupport {

    @Resource
    private FacheService service;

    @Test
    public void test_select() {
        List<Fache> result = service.selectByDate("2015-02-10 00:00:00",
                "2015-02-12 00:00:00");
        for (Fache fache : result) {
            System.err.println(fache.getDate());
        }
    }
}
