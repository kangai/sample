package org.sub.reacttest.front.controller;

import org.common.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/react")
public class ReactController extends BaseController {

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index() throws Exception {
		return "reacttest/react";
	}

	@RequestMapping(value = "/push", method = RequestMethod.GET)
	@ResponseBody
	public String push() throws Exception {

		String returnString = "[" +
				"	{" +
				"	\"author\": \"Pete Hunt\"," +
				"	\"text\": \"Hey there!\"" +
				"	}" +
				"]";
		return returnString;
	}
}
