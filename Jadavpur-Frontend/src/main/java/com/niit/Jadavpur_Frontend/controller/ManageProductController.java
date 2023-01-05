package com.niit.Jadavpur_Frontend.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.Jadavpur_Backend.DAO.CategoryDAO;
import com.niit.Jadavpur_Backend.DAO.ProductDAO;
import com.niit.Jadavpur_Backend.DAO.UserDAO;
import com.niit.Jadavpur_Backend.modal.Category;
import com.niit.Jadavpur_Backend.modal.Product;
import com.niit.Jadavpur_Backend.modal.User;
import com.niit.Jadavpur_Frontend.util.FileUpload;

@Controller
@RequestMapping(value={"/manage"})
public class ManageProductController 
{
	@Autowired
	CategoryDAO categoryDAO;
	
	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	UserDAO userDAO;
	
	
	
	@RequestMapping(value={"/product"})
	public ModelAndView manageProduct(@RequestParam(name="operation", required=false) String operation)
	{
		ModelAndView mv = new ModelAndView("index");
		
		mv.addObject("newProduct" , new Product());
		
		mv.addObject("userclickmanageproduct" , true);
		
		if(operation != null) 
		{
			if(operation.equals("product"))
			{
				mv.addObject("message", "Product added successfully!");
			}
		}
		return mv;	
	}
	
	@RequestMapping(value={"/add/product"})
	public String addProduct(@Valid @ModelAttribute("newProduct") Product p,BindingResult results , ModelMap model,HttpServletRequest request)
	{
		if(results.hasErrors()) 
		{
			
			model.addAttribute("userclickmanageproduct",true);
			return "index";
		}	
		else
		{
			productDAO.insert(p);
			
			if(! p.getFile().getOriginalFilename().equals("") )
			{
				FileUpload.uploadFile(request, p.getFile(), p.getCode()); 
			 }
			
			return "redirect:/manage/product?operation=product";
		}
			
		
	}
	
	
	
	@ModelAttribute("categorylist") 
	public List<Category> modelCategoryList() 
	{
		return categoryDAO.categoryList();
	}
	@ModelAttribute("supplierlist") 
	public List<User> modelSupplierList() 
	{
		return userDAO.getSupplierList();
	}
	
	@ModelAttribute("category") 
	public Category modelCategory() 
	{
		return new Category();
	}
	
}
