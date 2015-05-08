package org.sub.dbsample.service.logic.impl;

import org.common.service.BaseServiceLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sub.dbsample.db.dto.DdlResultDto;
import org.sub.dbsample.db.mapper.DdlExecuteMapper;
import org.sub.dbsample.service.parameter.DbSampleParameter;


/**
 * テストロジック
 */
@Service("ddlExecuteLogic")
public class DdlExecuteLogicImpl extends BaseServiceLogic<DbSampleParameter> {

	@Autowired
	private DdlExecuteMapper ddlExecuteMapper;

	@Override
	public void execute(DbSampleParameter bean) {
		ddlExecuteMapper.ddlExecute(bean.getSqlText());
	}

}