package com.jbarseg.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControllerMVC {
	
	@RequestMapping
	public String showPage(){
		return "examplePage";
	}

}
