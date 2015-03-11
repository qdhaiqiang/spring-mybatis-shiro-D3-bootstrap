package com.eliteams.quick4j.test.dao;

import com.eliteams.quick4j.core.feature.test.TestSupport;
import com.eliteams.quick4j.web.dao.QiugouMapper;
import com.eliteams.quick4j.web.dao.ResaleMapper;
import com.eliteams.quick4j.web.model.Qiugou;
import com.eliteams.quick4j.web.model.Resale;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

public class ResaleMapperTest extends TestSupport {
    @Resource
    private ResaleMapper mapper;

    @Test
    public void test_selectByDate() {
        start();
        List<Resale> results = mapper.selectByDate("2015-02-10 00:00:00",
                                                         "2015-04-10 00:00:00");
        for (Resale item : results) {
            System.err.println(item.getId());
        }
        end();
    }
}
