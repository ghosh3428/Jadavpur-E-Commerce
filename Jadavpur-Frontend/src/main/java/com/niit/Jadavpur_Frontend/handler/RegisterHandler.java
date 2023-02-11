package com.niit.Jadavpur_Frontend.handler;

import org.springframework.stereotype.Component;

import com.niit.Jadavpur_Backend.modal.Address;
import com.niit.Jadavpur_Backend.modal.User;
import com.niit.Jadavpur_Frontend.model.RegisterModel;

@Component("registerHandler")
public class RegisterHandler 
{
	public RegisterModel init()
	{
		return new RegisterModel();
	}
	
	public void addUser(RegisterModel registerModel, User user) {
		registerModel.setUser(user);
	}

	public void addBilling(RegisterModel registerModel, Address billing) {
		registerModel.setBilling(billing);
	}
	
	
}

