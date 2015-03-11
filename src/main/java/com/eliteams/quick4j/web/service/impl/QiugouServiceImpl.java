package com.eliteams.quick4j.web.service.impl;

import com.eliteams.quick4j.core.generic.GenericDao;
import com.eliteams.quick4j.core.generic.GenericServiceImpl;
import com.eliteams.quick4j.web.dao.ChatMapper;
import com.eliteams.quick4j.web.dao.QiugouMapper;
import com.eliteams.quick4j.web.model.Chat;
import com.eliteams.quick4j.web.model.Qiugou;
import com.eliteams.quick4j.web.service.ChatService;
import com.eliteams.quick4j.web.service.QiugouService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 角色Service实现类
 *
 * @author StarZou
 * @since 2014年6月10日 下午4:16:33
 */
@Service
public class QiugouServiceImpl extends
        GenericServiceImpl<Qiugou, Long>
        implements QiugouService {

    @Resource
    private QiugouMapper mapper;

    @Override
    public GenericDao<Qiugou, Long> getDao() {
        return mapper;
    }
}
