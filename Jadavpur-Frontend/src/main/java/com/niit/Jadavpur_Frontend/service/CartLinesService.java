package com.niit.Jadavpur_Frontend.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.Jadavpur_Backend.DAO.CartLinesDAO;
import com.niit.Jadavpur_Backend.DAO.ProductDAO;
import com.niit.Jadavpur_Backend.modal.Cart;
import com.niit.Jadavpur_Backend.modal.CartLines;
import com.niit.Jadavpur_Backend.modal.Product;
import com.niit.Jadavpur_Frontend.model.UserModel;

@Service("cartlinesService")
public class CartLinesService 
{
	@Autowired
	private HttpSession session;
	
	@Autowired 
	ProductDAO productDAO;
	
	@Autowired
	CartLinesDAO cartlinesDAO;
	
	private Cart getCart() 
	{
		return ((UserModel)session.getAttribute("userModel")).getCart();
	}
	
	public String addCartLineProduct(int p_Id) 
	{
		Cart cart = this.getCart();
		CartLines ct = new CartLines();
		Product p = productDAO.getProduct(p_Id);
		
		ct.setAvailable(true);
		ct.setBuyingPrice(p.getUnitPrice());
		ct.setCartId(cart.getId());
		ct.setProduct(p);
		ct.setProductCount(1);
		ct.setTotal(ct.getBuyingPrice() * ct.getProductCount());
		
		cartlinesDAO.add(ct);
		
		cart.setCartLines(cart.getCartLines() + 1);
		cart.setGrandTotal(cart.getGrandTotal() + ct.getTotal());
		
		cartlinesDAO.updateCart(cart);
		
		return "result=added";
	}

}
