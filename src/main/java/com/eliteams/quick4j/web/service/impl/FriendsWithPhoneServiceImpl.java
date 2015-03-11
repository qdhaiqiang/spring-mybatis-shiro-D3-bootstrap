package com.eliteams.quick4j.web.service.impl;

import com.eliteams.quick4j.core.generic.GenericDao;
import com.eliteams.quick4j.core.generic.GenericServiceImpl;
import com.eliteams.quick4j.web.dao.ChatMapper;
import com.eliteams.quick4j.web.dao.FriendsWithPhoneMapper;
import com.eliteams.quick4j.web.model.Chat;
import com.eliteams.quick4j.web.model.FriendsWithPhone;
import com.eliteams.quick4j.web.service.FriendsWithPhoneService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 角色Service实现类
 *
 * @author StarZou
 * @since 2014年6月10日 下午4:16:33
 */
@Service
public class FriendsWithPhoneServiceImpl extends
        GenericServiceImpl<FriendsWithPhone, Long>
        implements FriendsWithPhoneService {

    @Resource
    private FriendsWithPhoneMapper mapper;

    @Override
    public GenericDao<FriendsWithPhone, Long> getDao() {
        return mapper;
    }
}
