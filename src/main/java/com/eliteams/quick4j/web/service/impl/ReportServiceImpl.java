package com.eliteams.quick4j.web.service.impl;

import com.eliteams.quick4j.core.generic.GenericDao;
import com.eliteams.quick4j.core.generic.GenericServiceImpl;
import com.eliteams.quick4j.web.dao.FacheMapper;
import com.eliteams.quick4j.web.dao.ReportMapper;
import com.eliteams.quick4j.web.model.Fache;
import com.eliteams.quick4j.web.model.Report;
import com.eliteams.quick4j.web.service.FacheService;
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
public class ReportServiceImpl extends
        GenericServiceImpl<Report, Long>
        implements ReportService {

    @Resource
    private ReportMapper mapper;

    @Override
    public GenericDao<Report, Long> getDao() {
        return mapper;
    }
}
