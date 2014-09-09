package s3.controller;

import groovy.transform.TypeChecked

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody

import s3.form.HelloForm
import s3.form.HelloForm_Item

@TypeChecked
@Controller
@RequestMapping(value="/HelloJSON",method=RequestMethod.POST)
class HelloJSONController {

	@RequestMapping(value="/init")
	@ResponseBody
	HelloForm init() {
		
		def helloForm = new HelloForm();
		helloForm.firstName = "初期値F";
		helloForm.lastName = "初期値L";

		return helloForm;
	}

	@RequestMapping(value="/addHistory")
	@ResponseBody
	HelloForm addHistory(@RequestBody HelloForm helloForm) {

		helloForm.history << {
			def item = new HelloForm_Item();
			item.firstName = helloForm.firstName;
			item.lastName = helloForm.lastName;
			item.date = new Date().format('MM/dd HH:mm:ss');
			item.firstName = helloForm.firstName;
			return item;
		}();

		println(helloForm);

		return helloForm;
	}
}
