package org.sub.wstest.front.socket;

import java.io.IOException;
import java.util.Map.Entry;

import net.arnx.jsonic.JSON;

import org.common.handler.WebSocketTextHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.sub.wstest.front.form.ChatForm;
import org.sub.wstest.service.facade.ChatServiceFacade;
import org.sub.wstest.service.parameter.ChatParameter;

@Component("chatHandler")
public class ChatHandler extends WebSocketTextHandler {

	@Autowired
	protected ChatServiceFacade chatServiceFacade;

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {

		super.afterConnectionEstablished(session);

		// 接続者全員に送る
		ChatForm form = new ChatForm();
		form.setMessage("ID:" + session.getId() + "開始");
		// メッセージ送信
		sendMessage(form);
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {

		super.afterConnectionClosed(session, status);

		// 接続者全員に送る
		ChatForm form = new ChatForm();
		form.setMessage("ID:" + session.getId() + "終了");
		// メッセージ送信
		sendMessage(form);
	}

	@Override
	public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {

		// JSON→オブジェクト変換
		ChatForm form = JSON.decode(message.getPayload(), ChatForm.class);
		ChatParameter parameter = new ChatParameter();
		// コピー(form→parameter)
		BeanUtils.copyProperties(form, parameter);

		// ダミー処理
		chatServiceFacade.process(parameter);

		// コピー(parameter→form)
		BeanUtils.copyProperties(parameter, form);

		// メッセージ送信
		sendMessage(form);
	}

	/**
	 * メッセージ送信
	 * 
	 * @param form
	 * @throws IOException
	 */
	private void sendMessage(ChatForm form) throws IOException {

		// セッション数セット
		form.setSessionCount(String.valueOf(getSessionMap().size()));
		// オブジェクト変換→JSON
		String text = JSON.encode(form);

		// 接続されているセッション（自分も含め）に転送する。
		for (Entry<String, WebSocketSession> entry : getSessionMap().entrySet()) {
			entry.getValue().sendMessage(new TextMessage(text));
		}
	}
}
