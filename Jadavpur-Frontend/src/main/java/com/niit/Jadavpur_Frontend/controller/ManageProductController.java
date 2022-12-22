package com.niit.Jadavpur_Frontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.Jadavpur_Backend.DAO.CategoryDAO;
import com.niit.Jadavpur_Backend.DAO.UserDAO;
import com.niit.Jadavpur_Backend.modal.Product;

@Controller
@RequestMapping(value={"/manage"})
public class ManageProductController 
{
	@Autowired
	CategoryDAO categoryDAO;
	
	@Autowired
	UserDAO userDAO;
	
	@RequestMapping(value={"/product"})
	public ModelAndView manageProduct()
	{
		ModelAndView mv = new ModelAndView("index");
		
		mv.addObject("userclickmanageproduct" , true);
		mv.addObject("categorylist" , categoryDAO.categoryList());
		mv.addObject("supplierlist" , userDAO.getSupplierList());
		mv.addObject("newProduct" , new Product());
		
		return mv;
		
	}

}
