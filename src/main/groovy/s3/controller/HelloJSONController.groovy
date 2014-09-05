package s3.controller;

import groovy.transform.TypeChecked

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody

import s3.form.HelloForm
import s3.form.Item

@TypeChecked
@Controller
class HelloJSONController {

	@RequestMapping(value="/HelloJSON",method=RequestMethod.POST)
	@ResponseBody
	HelloForm exec(@RequestBody HelloForm helloForm) {

		Item item = new Item();
		item.firstName = helloForm.firstName;
		item.lastName = helloForm.lastName;
		item.date = new Date().format('MM/dd HH:mm:ss');
		item.firstName = helloForm.firstName;
		helloForm.history << item;

		println(helloForm);

		return helloForm;
	}
}
