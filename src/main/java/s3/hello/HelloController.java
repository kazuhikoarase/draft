package s3.hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("hello")
public class HelloController {

	@RequestMapping(value="/hello", method=RequestMethod.GET)
	public String init(ModelMap model) {
		Hello hello = new Hello();
		hello.setFirstName("$F$");
		hello.setLastName("$L$");
		model.addAttribute("hello", hello);
		return "hello-view";
	}

	@RequestMapping(value="/hello", method=RequestMethod.POST)
	public String exec(@ModelAttribute("hello") Hello hello) {
		System.out.println("[" +
				hello.getFirstName() +
				" " +
				hello.getLastName() +
				"]");
		return "hello-view";
	}

}