package org.sub.dbsample.front.controller;

import org.common.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.sub.dbsample.front.form.DbSampleForm;
import org.sub.wstest.front.form.ChatForm;

@Controller
@RequestMapping("/dbSample")
public class DbSampleController extends BaseController {

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(DbSampleForm dbSampleForm, Errors errors, Model model) throws Exception {
		return "dbsample/create";
	}
}
