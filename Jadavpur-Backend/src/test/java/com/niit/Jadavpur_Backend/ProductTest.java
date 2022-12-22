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
		product.setId(3);
		product.setName("15s-fr2512TU");
		product.setBrand("HP");
		product.setDescription("512 GB PCIe® NVMe™ M.2 SSD\r\n" + 
				"8 GB DDR4-3200 MHz RAM (1 x 8 GB)");
		product.setUnitPrice(46999.00);
		product.setActive(true);
		product.setCategoryId(5);
		product.setSupplierId(2);
		product.setQuantity(3);
		
		assertEquals("Error" , true , productDAO.insert(product));
	}
	
	//@Test
	public void testGetProduct()
	{
		product = productDAO.getProduct(1);
		
		assertEquals("Error" , "PRDf311b4016544", product.getCode());
	}
	
	//@Test
	public void testActiveProduct()
	{
		assertEquals("Error" ,3, productDAO.listActiveProducts().size());
	}
	
	//@Test
	public void testActiveCategoryProduct()
	{
		assertEquals("Error" ,2, productDAO.listActiveProductsByCategory(5).size());
	}
	
	
}
