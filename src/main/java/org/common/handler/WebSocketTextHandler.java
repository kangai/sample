package org.common.handler;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/**
 * WEbSocket用のハンドラ―基底クラス
 */
public class WebSocketTextHandler extends TextWebSocketHandler {

	private Map<String, WebSocketSession> sessionMap = new ConcurrentHashMap<String, WebSocketSession>();

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		// WebSocketの接続が開かれ、使用できる状態にした後に呼び出される。
		this.sessionMap.put(session.getId(), session);
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		// WebSocketの接続が閉じられた後、またはトランスポートエラーが発生した後に呼び出される。
		this.sessionMap.remove(session.getId());
	}

	/**
	 * セッション一覧を取得
	 * 
	 * @return
	 */
	protected Map<String, WebSocketSession> getSessionMap() {
		// 変更負荷
		return Collections.unmodifiableMap(sessionMap);
	}
}
