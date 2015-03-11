package com.eliteams.quick4j.test.dao;

import com.eliteams.quick4j.core.feature.test.TestSupport;
import com.eliteams.quick4j.web.dao.QiugouMapper;
import com.eliteams.quick4j.web.dao.XunjiaMapper;
import com.eliteams.quick4j.web.model.Qiugou;
import com.eliteams.quick4j.web.model.Xunjia;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

public class XunjiaMapperTest extends TestSupport {
    @Resource
    private XunjiaMapper xunjiaMapper;

    @Test
    public void test_selectByDate() {
        start();
        List<Xunjia> xunjias = xunjiaMapper.selectByDate("2015-02-10 00:00:00",
                                                         "2015-02-12 00:00:00");
        for (Xunjia xunjia : xunjias) {
            System.err.println(xunjia.getDate());
        }
        end();
    }
}
