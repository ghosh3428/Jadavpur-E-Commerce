package com.niit.Jadavpur_Backend.DAO;

import java.util.List;

import com.niit.Jadavpur_Backend.modal.Cart;
import com.niit.Jadavpur_Backend.modal.CartLines;

public interface CartLinesDAO 
{
	public List<CartLines> list(int cartId);
	public CartLines get(int id);	
	public boolean add(CartLines cartLine);
	public boolean update(CartLines cartLine);
	public boolean remove(CartLines cartLine);
	boolean updateCart(Cart cart);
	public List<CartLines> listAvailable(int cartId);
	public CartLines getByCartAndProduct(int cartId, int productId);	
}
