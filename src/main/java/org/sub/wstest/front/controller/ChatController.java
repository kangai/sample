package org.sub.wstest.front.controller;

import org.common.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.sub.wstest.front.form.ChatForm;

@Controller
@RequestMapping("/chat")
public class ChatController extends BaseController {

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(ChatForm chatForm, Errors errors, Model model) throws Exception {
		return "wstest/chat";
	}
}
