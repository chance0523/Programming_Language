package com.mycom.myapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ViewController {

	@RequestMapping("/view")
	public String view() {
		return "Boot";
	}
	
	@RequestMapping("/viewModel")
	public String viewModel(Model model) {
		model.addAttribute("name", "안녕, Boot viewModel!!");
		return "viewModel";
	}
	
	@RequestMapping("/modelAndView")
	public ModelAndView modelAndView() {
		ModelAndView mav = new ModelAndView("modelAndView");
		mav.addObject("name", "안녕, Boot modelAndView");
		return mav;
	}
	
	
}
