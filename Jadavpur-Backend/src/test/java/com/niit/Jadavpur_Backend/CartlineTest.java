package com.niit.Jadavpur_Backend;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Jadavpur_Backend.DAO.CartLinesDAO;
import com.niit.Jadavpur_Backend.DAO.CategoryDAO;
import com.niit.Jadavpur_Backend.DAO.ProductDAO;
import com.niit.Jadavpur_Backend.modal.CartLines;
import com.niit.Jadavpur_Backend.modal.Category;
import com.niit.Jadavpur_Backend.modal.Product;

public class CartlineTest 
{
	private static AnnotationConfigApplicationContext context;
	static Product product;
	static ProductDAO productDAO;
	static CartLines cartlines;
	static CartLinesDAO cartlinesDAO;
	
	@BeforeClass
	public static void init() 
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.Jadavpur_Backend");
		context.refresh();
		
		productDAO = (ProductDAO)context.getBean("productDAO");
		cartlinesDAO = (CartLinesDAO)context.getBean("cartlinesDAO");
	}
	
	@Test
	public void testInsert()
	{
		product = productDAO.getProduct(3);
		
		cartlines = new CartLines();
		
		cartlines.setProduct(product);
		cartlines.setCartId(1);
		cartlines.setProductCount(5);
		cartlines.setBuyingPrice(product.getUnitPrice());
		cartlines.setTotal(cartlines.getBuyingPrice() * cartlines.getProductCount());
		cartlines.setAvailable(true);
		
		assertEquals("Error adding cartline" , true , cartlinesDAO.add(cartlines));
	}
}
