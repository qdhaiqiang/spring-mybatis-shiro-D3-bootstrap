package com.eliteams.quick4j.web.service.impl;

import com.eliteams.quick4j.core.generic.GenericDao;
import com.eliteams.quick4j.core.generic.GenericServiceImpl;
import com.eliteams.quick4j.web.dao.ChatMapper;
import com.eliteams.quick4j.web.dao.ResaleMapper;
import com.eliteams.quick4j.web.model.Chat;
import com.eliteams.quick4j.web.model.Resale;
import com.eliteams.quick4j.web.service.ChatService;
import com.eliteams.quick4j.web.service.ResaleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 角色Service实现类
 *
 * @author StarZou
 * @since 2014年6月10日 下午4:16:33
 */
@Service
public class ResaleServiceImpl extends
        GenericServiceImpl<Resale, Long>
        implements ResaleService {

    @Resource
    private ResaleMapper mapper;

    @Override
    public GenericDao<Resale, Long> getDao() {
        return mapper;
    }
}
