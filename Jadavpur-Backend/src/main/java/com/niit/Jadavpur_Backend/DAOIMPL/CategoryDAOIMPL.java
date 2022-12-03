package com.niit.Jadavpur_Backend.DAOIMPL;

import java.sql.SQLException;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.Jadavpur_Backend.DAO.CategoryDAO;
import com.niit.Jadavpur_Backend.modal.Category;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOIMPL implements CategoryDAO {
	@Autowired
	SessionFactory sessionFactory;

	public boolean insert(Category category)  
	{
		try 
		{
			sessionFactory.getCurrentSession().persist(category);
			return true;
		} 
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
