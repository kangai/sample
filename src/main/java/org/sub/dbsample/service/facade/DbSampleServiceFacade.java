package org.sub.dbsample.service.facade;

import org.common.service.BaseServiceFacade;
import org.common.service.LogicInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sub.dbsample.service.logic.impl.DdlExecuteLogicImpl;
import org.sub.dbsample.service.parameter.DbSampleParameter;
import org.sub.wstest.service.parameter.ChatParameter;

@Service("dbSampleServiceFacade")
public class DbSampleServiceFacade extends BaseServiceFacade {

	@Autowired
	protected LogicInterface<DbSampleParameter> ddlExecuteLogic;

	@Autowired
	protected LogicInterface<DbSampleParameter> tableListLogic;

	public void load(DbSampleParameter dbSampleParameter) {

		tableListLogic.execute(dbSampleParameter);
	}

	public void process(DbSampleParameter dbSampleParameter) {

		ddlExecuteLogic.execute(dbSampleParameter);
	}
}
