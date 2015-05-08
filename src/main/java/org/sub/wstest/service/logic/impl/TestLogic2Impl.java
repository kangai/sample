package org.sub.wstest.service.logic.impl;

import org.common.service.BaseServiceLogic;
import org.springframework.stereotype.Service;
import org.sub.wstest.service.parameter.ChatParameter;

/**
 * テストロジック
 */
@Service("testLogic2")
public class TestLogic2Impl extends BaseServiceLogic<ChatParameter> {

	@Override
	public void execute(ChatParameter bean) {
		System.out.println("test2");
	}

}
