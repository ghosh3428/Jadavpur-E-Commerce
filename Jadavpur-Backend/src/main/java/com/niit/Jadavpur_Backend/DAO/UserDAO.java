package com.niit.Jadavpur_Backend.DAO;

import java.util.List;

import com.niit.Jadavpur_Backend.modal.Address;
import com.niit.Jadavpur_Backend.modal.User;

public interface UserDAO 
{
	public boolean insert(User user);
	public User getUser(String email);
	public List<User> getSupplierList();
	
	public boolean insertAddress(Address address);
	public Address getBillingAddress(int id);
	public List<Address> getShippingAddress(int id);
}
