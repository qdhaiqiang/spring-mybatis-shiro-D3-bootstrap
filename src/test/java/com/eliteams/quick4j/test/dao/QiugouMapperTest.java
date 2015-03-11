package com.eliteams.quick4j.test.dao;

import com.eliteams.quick4j.core.feature.orm.mybatis.Page;
import com.eliteams.quick4j.core.feature.test.TestSupport;
import com.eliteams.quick4j.web.dao.UserMapper;
import com.eliteams.quick4j.web.dao.QiugouMapper;
import com.eliteams.quick4j.web.model.Qiugou;
import com.eliteams.quick4j.web.model.User;
import com.eliteams.quick4j.web.model.UserExample;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

public class QiugouMapperTest extends TestSupport {
    @Resource
    private QiugouMapper qiugouMapper;

    @Test
    public void test_selectByDate() {
        start();
        List<Qiugou> qiugous = qiugouMapper.selectByDate("2015-02-10 00:00:00",
                                                         "2015-04-10 00:00:00");
        for (Qiugou qiugou : qiugous) {
            System.err.println(qiugou.getId());
            System.err.println(qiugou.getName());
            System.err.println(qiugou.getDatetime());
        }
        end();
    }
}
