'use strict';
function SocketPushService() {
	var service = {};
	//callback用
	var pendingCallbacks = [];
	var ws = new WebSocket("ws://172.31.122.33:8080/project-support/websocket/createTable");
	var preConnectionRequests = [];
	var connected = false;

	//コネクションオープン
	ws.onopen = function () {
		connected = true;
		if (preConnectionRequests.length === 0) return;

		console.log('Sending (%d) requests', preConnectionRequests.length);
		for (var i = 0, c = preConnectionRequests.length; i < c; i++) {
			ws.send(JSON.stringify(preConnectionRequests[i]));
		}
		preConnectionRequests = [];
	};

	//受信
	ws.onmessage = function (message) {
		console.log("########### ws.onmessage ##########", message);
		listener(JSON.parse(message.data));
	};

	//Callbackの登録
	function bindReceiveListener(cb) {
		//pendingCallbacks[generateMessageId()] = cb;
		pendingCallbacks.push(cb);
	}

	//リクエスト送信
	function sendRequest(request) {
		if (!connected) {
			console.log('Not connected yet, saving request', request);
			preConnectionRequests.push(request);
			return;
		}
		console.log('Sending request', request);
		ws.send(JSON.stringify(request));
	}

	//受信時のリスナー
	function listener(message) {
		//pendingCallbacks[generateMessageId()](message);
		pendingCallbacks.forEach(function(value) {
			value(message);
		});
	}

	service.sendRequest = sendRequest;
	service.bindReceiveListener = bindReceiveListener;
	return service;
}