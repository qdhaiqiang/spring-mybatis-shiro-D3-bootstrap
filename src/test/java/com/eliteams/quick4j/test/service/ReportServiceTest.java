package com.eliteams.quick4j.test.service;

import com.eliteams.quick4j.core.feature.test.TestSupport;
import com.eliteams.quick4j.web.model.Fache;
import com.eliteams.quick4j.web.model.Report;
import com.eliteams.quick4j.web.service.FacheService;
import com.eliteams.quick4j.web.service.ReportService;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

public class ReportServiceTest extends TestSupport {

    @Resource
    private ReportService service;

    @Test
    public void test_select() {
        List<Report> result = service.selectByDate("2015-02-10 00:00:00",
                "2015-02-12 00:00:00");
        for (Report report : result) {
            System.err.println(report.getDate());
        }
    }
}
