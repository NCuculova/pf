package mk.ukim.finki.ki.pf.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

	/**
	 * Method that loads index.jsp on page load and refresh
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home() {
		ModelAndView result = new ModelAndView("index");
		return result;
	}

}
