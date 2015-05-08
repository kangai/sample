package org.sub.dbsample.front.form;

import org.sub.dbsample.db.dto.DdlResultDto;

import java.util.LinkedList;
import java.util.List;

public class DbSampleForm {

	private String messageId = null;

	private String messageType = null;

	private String tableName = null;

	private String sqlText = null;

	private String message = null;

	private List<DdlResultDto> tables = new LinkedList<DdlResultDto>();

	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	public String getMessageType() {
		return messageType;
	}

	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getSqlText() {
		return sqlText;
	}

	public void setSqlText(String sqlText) {
		this.sqlText = sqlText;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<DdlResultDto> getTables() {
		return tables;
	}

	public void setTables(List<DdlResultDto> tables) {
		this.tables = tables;
	}
}
