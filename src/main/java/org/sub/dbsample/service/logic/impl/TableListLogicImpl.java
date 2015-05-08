package org.sub.dbsample.service.logic.impl;

import org.common.service.BaseServiceLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sub.dbsample.db.mapper.DdlExecuteMapper;
import org.sub.dbsample.db.dto.DdlResultDto;
import org.sub.dbsample.service.parameter.DbSampleParameter;

import java.util.List;


/**
 * テストロジック
 */
@Service("tableListLogic")
public class TableListLogicImpl extends BaseServiceLogic<DbSampleParameter> {

	@Autowired
	DdlExecuteMapper ddlExecuteMapper;

	@Override
	public void execute(DbSampleParameter bean) {
		List<DdlResultDto> list = ddlExecuteMapper.tableList();
		bean.setTables(list);
	}
}