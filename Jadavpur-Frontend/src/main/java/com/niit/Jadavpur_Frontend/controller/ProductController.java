package com.niit.Jadavpur_Frontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.Jadavpur_Backend.DAO.CategoryDAO;

@Controller
@RequestMapping(value="/product")
public class ProductController 
{
	@Autowired
	CategoryDAO categoryDAO;
	
	@RequestMapping(value="/view/all/product")
	public ModelAndView viewAllProduct()
	{
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("title" , "Online Shopping - All Products");
		mv.addObject("userclickallproducts" , true);
		mv.addObject("categoryList" , categoryDAO.categoryList());
		return mv;
	}

	@RequestMapping(value="/view/category/{id}/product")
	public ModelAndView viewCategoryProduct(@PathVariable("id") int c_id)
	{
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("title" , "Online Shopping - Category Products");
		mv.addObject("userclickcategoryproducts" , true);
		mv.addObject("categoryList" , categoryDAO.categoryList());
		mv.addObject("category" , categoryDAO.getCategory(c_id));
		return mv;
	}
}
