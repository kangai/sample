package org.sub.dbsample.front.socket;

import net.arnx.jsonic.JSON;
import org.common.handler.WebSocketTextHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.sub.dbsample.db.dto.DdlResultDto;
import org.sub.dbsample.front.form.DbSampleForm;
import org.sub.dbsample.service.facade.DbSampleServiceFacade;
import org.sub.dbsample.service.parameter.DbSampleParameter;

import java.util.List;
import java.util.Map.Entry;

@Component("dbSampleHandler")
public class DbSampleHandler extends WebSocketTextHandler {

	@Autowired
	protected DbSampleServiceFacade dbSampleServiceFacade;

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		super.afterConnectionEstablished(session);
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		super.afterConnectionClosed(session, status);
	}

	@Override
	public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {

		// JSON→オブジェクト変換
		DbSampleForm form = JSON.decode(message.getPayload(), DbSampleForm.class);
		DbSampleParameter parameter = new DbSampleParameter();
		// コピー(form→parameter)
		BeanUtils.copyProperties(form, parameter);

		//※create時のみ実行
		//格好悪いのでHandlerを拡張してうまいことやったほうがよい。
		if(form.getMessageType().equals("createTables")) {
			dbSampleServiceFacade.process(parameter);
		}

		// Table一覧
		dbSampleServiceFacade.load(parameter);

		// コピー(parameter→form)
		BeanUtils.copyProperties(parameter, form);
		form.setMessageType("dataCompleted");

		// オブジェクト変換→JSON
		String text = JSON.encode(form);

		// 接続されているセッション（自分も含め）に転送する。
		for (Entry<String, WebSocketSession> entry : getSessionMap().entrySet()) {
			entry.getValue().sendMessage(new TextMessage(text));
		}
	}
}
