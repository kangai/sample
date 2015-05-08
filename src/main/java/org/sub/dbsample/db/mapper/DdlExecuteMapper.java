package org.sub.dbsample.db.mapper;

import org.sub.dbsample.db.dto.DdlResultDto;

import java.util.List;

/**
 * Created by 0A9334 on 2015/04/07.
 */
public interface DdlExecuteMapper {

    int test();

    void ddlExecute(String sqltext);

    List<DdlResultDto> tableList();

    DdlResultDto tableSingle(String name);

}
