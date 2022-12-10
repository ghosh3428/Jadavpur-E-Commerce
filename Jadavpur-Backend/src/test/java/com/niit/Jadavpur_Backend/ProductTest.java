package com.niit.Jadavpur_Backend;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Jadavpur_Backend.DAO.ProductDAO;
import com.niit.Jadavpur_Backend.modal.Product;

public class ProductTest 
{

	private static AnnotationConfigApplicationContext context;
	static Product product;
	static ProductDAO productDAO;	
	
	@BeforeClass
	public static void init() 
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.Jadavpur_Backend");
		context.refresh();
		
		productDAO = (ProductDAO)context.getBean("productDAO");
	}
	
	@Test
	public void testInsert()
	{
		product = new Product();
		product.setId(1);
		product.setName("boAt Storm Smartwatch ");
		product.setBrand("boAt ");
		product.setDescription("Get ready to keep a track of your fitness and health stats in style with the boAt Storm Smartwatch. Featuring an elegant design, this smartwatch is sure to be your fitness companion at all times.");
		product.setUnitPrice(1999);
		product.setActive(true);
		product.setCategoryId(2);
		product.setSupplierId(2);
		product.setQuantity(5);
		
		assertEquals("Error" , true , productDAO.insert(product));
	}
}
