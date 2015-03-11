package com.eliteams.quick4j.web.service.impl;

import com.eliteams.quick4j.core.generic.GenericDao;
import com.eliteams.quick4j.core.generic.GenericServiceImpl;
import com.eliteams.quick4j.web.dao.FacheMapper;
import com.eliteams.quick4j.web.dao.XunjiaMapper;
import com.eliteams.quick4j.web.model.Fache;
import com.eliteams.quick4j.web.model.Xunjia;
import com.eliteams.quick4j.web.service.FacheService;
import com.eliteams.quick4j.web.service.XunjiaService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 角色Service实现类
 *
 * @author StarZou
 * @since 2014年6月10日 下午4:16:33
 */
@Service
public class FacheServiceImpl extends
        GenericServiceImpl<Fache, Long>
        implements FacheService {

    @Resource
    private FacheMapper mapper;

    @Override
    public GenericDao<Fache, Long> getDao() {
        return mapper;
    }
}
