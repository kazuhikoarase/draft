package s3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import s3.form.HelloForm;
import s3.service.MessageService;

@Controller
class HelloJSONController {
	@RequestMapping(value="/HelloJSON",method=RequestMethod.POST)
	@ResponseBody
	HelloForm exec(@RequestBody HelloForm helloForm) {
		println("[" +
				helloForm.getFirstName() +
				" " +
				helloForm.getLastName() +
				"]");
		return helloForm;
	}
}
