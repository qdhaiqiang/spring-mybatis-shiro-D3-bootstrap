package com.eliteams.quick4j.web.service.impl;

import com.eliteams.quick4j.core.generic.GenericDao;
import com.eliteams.quick4j.core.generic.GenericServiceImpl;
import com.eliteams.quick4j.web.dao.RoleMapper;
import com.eliteams.quick4j.web.dao.XunjiaMapper;
import com.eliteams.quick4j.web.model.Role;
import com.eliteams.quick4j.web.model.Xunjia;
import com.eliteams.quick4j.web.service.RoleService;
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
public class XunjiaServiceImpl extends
        GenericServiceImpl<Xunjia, Long>
        implements XunjiaService {

    @Resource
    private XunjiaMapper xunJiaMapper;

    @Override
    public GenericDao<Xunjia, Long> getDao() {
        return xunJiaMapper;
    }
}
