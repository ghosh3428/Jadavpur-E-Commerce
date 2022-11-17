package com.niit.Jadavpur_Frontend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController 
{

	@RequestMapping(value={"/","/home","/index"})
	public ModelAndView index()
	{
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("message" , "WELCOME TO NIIIT JADAVPUR");
		return mv;
	}
	
	@RequestMapping(value="/about")
	public ModelAndView about()
	{
		ModelAndView mv = new ModelAndView("about");
		mv.addObject("message" , "About Us Page");
		return mv;
	}
}
