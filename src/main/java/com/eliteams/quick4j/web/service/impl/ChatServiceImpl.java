package com.eliteams.quick4j.web.service.impl;

import com.eliteams.quick4j.core.generic.GenericDao;
import com.eliteams.quick4j.core.generic.GenericServiceImpl;
import com.eliteams.quick4j.web.dao.ChatMapper;
import com.eliteams.quick4j.web.dao.ReportMapper;
import com.eliteams.quick4j.web.model.Chat;
import com.eliteams.quick4j.web.model.Report;
import com.eliteams.quick4j.web.service.ChatService;
import com.eliteams.quick4j.web.service.ReportService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 角色Service实现类
 *
 * @author StarZou
 * @since 2014年6月10日 下午4:16:33
 */
@Service
public class ChatServiceImpl extends
        GenericServiceImpl<Chat, Long>
        implements ChatService {

    @Resource
    private ChatMapper mapper;

    @Override
    public GenericDao<Chat, Long> getDao() {
        return mapper;
    }
}
