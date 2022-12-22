package com.niit.Jadavpur_Backend.DAOIMPL;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.Jadavpur_Backend.DAO.UserDAO;
import com.niit.Jadavpur_Backend.modal.User;

@Transactional
@Repository("userDAO")
public class UserDAOIMPL implements UserDAO 
{
	@Autowired
	SessionFactory sessionFactory;
	
	public boolean insert(User user) 
	{
		try
		{
			sessionFactory.getCurrentSession().persist(user);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}


	public User getUser(String email) 
	{
	
		try
		{
			String selectuser = "FROM User WHERE email = :email";
			
			Query query = sessionFactory.getCurrentSession().createQuery(selectuser);
					
			query.setParameter("email", email);
							
			return (User) query.getSingleResult();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}


	@Override
	public List<User> getSupplierList() 
	{
		try
		{
			String selectuser = "FROM User WHERE role = :role and enabled = :enabled";
			
			Query query = sessionFactory.getCurrentSession().createQuery(selectuser);
					
			query.setParameter("role", "SUPPLIER");
			query.setParameter("enabled", true);
							
			return query.getResultList();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

}
