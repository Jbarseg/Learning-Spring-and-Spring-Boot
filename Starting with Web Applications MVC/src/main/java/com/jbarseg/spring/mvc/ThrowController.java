package com.jbarseg.spring.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("Secondary")
public class ThrowController {
	
	@RequestMapping("/processForm2")
	//public String otherFormProcess(HttpServletRequest request, Model model){
	public String otherFormProcess(@RequestParam("realName") String name, Model model){
		//String name = request.getParameter("realName");
		name += " is a fake person";
		String finalMessage = "Who is a fake person? " + name;
		model.addAttribute("finalMessage", finalMessage);
		return "FirstProcessFormTest";
	}
}