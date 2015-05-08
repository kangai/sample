package org.sub.wstest.service.facade;

import org.common.service.BaseServiceFacade;
import org.common.service.LogicInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sub.wstest.service.parameter.ChatParameter;

@Service("chatServiceFacade")
public class ChatServiceFacade extends BaseServiceFacade {

	@Autowired
	protected LogicInterface<ChatParameter> testLogic1;

	@Autowired
	protected LogicInterface<ChatParameter> testLogic2;

	/**
	 * テスト処理
	 * 
	 * @param chatParameter
	 */
	public void process(ChatParameter chatParameter) {

		testLogic1.execute(chatParameter);

		testLogic2.execute(chatParameter);
	}
}
