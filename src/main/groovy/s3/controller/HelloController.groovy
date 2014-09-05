package s3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import s3.form.HelloForm;
import s3.service.MessageService;

@Controller
@SessionAttributes
@RequestMapping("/Hello")
class HelloController {

	@Autowired
	private MessageService messageService;

	@RequestMapping(method=RequestMethod.GET)
	String init(ModelMap model) {

		HelloForm helloForm = new HelloForm();
		helloForm.firstName = messageService.getMessage();
		helloForm.lastName = "groovy";
		model.addAttribute("helloForm", helloForm);
		return "HelloView";
	}

	@RequestMapping(method=RequestMethod.POST)
	String exec(@ModelAttribute("helloForm") HelloForm helloForm) {
		println("[" +
				helloForm.getFirstName() +
				" " +
				helloForm.getLastName() +
				"]");
		return "HelloView";
	}
}
