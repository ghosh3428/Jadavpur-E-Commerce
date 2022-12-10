package com.niit.Jadavpur_Backend.DAOIMPL;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.Jadavpur_Backend.DAO.ProductDAO;
import com.niit.Jadavpur_Backend.modal.Product;

@Transactional
@Repository("productDAO")
public class ProductDAOIMPL implements ProductDAO 
{
	@Autowired
	SessionFactory sessionFactory;
	
	
	public boolean insert(Product product) 
	{
		try {
			sessionFactory.getCurrentSession().persist(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
