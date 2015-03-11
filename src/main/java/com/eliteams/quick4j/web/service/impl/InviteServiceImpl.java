package com.eliteams.quick4j.web.service.impl;

import com.eliteams.quick4j.core.generic.GenericDao;
import com.eliteams.quick4j.core.generic.GenericServiceImpl;
import com.eliteams.quick4j.web.dao.ChatMapper;
import com.eliteams.quick4j.web.dao.InviteMapper;
import com.eliteams.quick4j.web.model.Chat;
import com.eliteams.quick4j.web.model.Invite;
import com.eliteams.quick4j.web.service.ChatService;
import com.eliteams.quick4j.web.service.InviteService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 角色Service实现类
 *
 * @author StarZou
 * @since 2014年6月10日 下午4:16:33
 */
@Service
public class InviteServiceImpl extends
        GenericServiceImpl<Invite, Long>
        implements InviteService {

    @Resource
    private InviteMapper mapper;

    @Override
    public GenericDao<Invite, Long> getDao() {
        return mapper;
    }
}
