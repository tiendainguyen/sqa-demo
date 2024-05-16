package com.example.demo.service.Impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import com.example.demo.entity.CartItem;
import com.example.demo.repository.ShoppingCartRepository;
import com.example.demo.service.ShoppingCartService;

@SessionScope
@Service
public class ShoppingCartServiceImpl implements ShoppingCartService{
	
	private ShoppingCartRepository shoppingCartRepository;
	
	
	public ShoppingCartServiceImpl(ShoppingCartRepository shoppingCartRepository, Map<Integer, CartItem> maps) {
		super();
		this.shoppingCartRepository = shoppingCartRepository;
		this.maps = maps;
	}

	Map<Integer, CartItem> maps = new HashMap<>();
	@Override
	public void add(CartItem item) {
		CartItem cartItem = maps.get(item.getComputerId());
		if (cartItem == null) {
			maps.put(item.getComputerId(), item);
		}else {
			cartItem.setSoluong(cartItem.getSoluong()+1);
		}
		shoppingCartRepository.save(item);
	}
	
	@Override
	public void remove(int id) {
//		maps.remove(id);
		shoppingCartRepository.deleteById(id);
	}
	
	@Override
	public CartItem update(int computerId, int soluong) {
		CartItem cartItem = maps.get(computerId);
		cartItem.setSoluong(soluong);
		shoppingCartRepository.save(cartItem);
		return cartItem;
	}
	
//	@Override
//	public void clear() {
//		maps.clear();
//		shoppingCartRepository.deleteAll();
//	}
	
	@Override
	public Collection<CartItem> getAllItems(){
		return maps.values();
	}
	
	@Override
	public int getCount() {
		return maps.values().size();
	}
	
//	@Override
//	public float getAmount() {
//		return (float) maps.values().stream().mapToDouble(item -> item.getSoluong() * item.getGia()).sum();
//	}

	@Override
	public List<CartItem> getCartByUsername(String username) {
		// TODO Auto-generated method stub
		return shoppingCartRepository.getCartByUsername(username);
	}

	@Override
	public float getAmount(String username) {
		List<CartItem> list = shoppingCartRepository.getCartByUsername(username);
		float amount= 0;
		for (CartItem cartItem:list) {
			amount += (cartItem.getSoluong()*cartItem.getGia());
		}
		// TODO Auto-generated method stub
		return amount;
	}

	@Override
	public void clear(String username) {
		// TODO Auto-generated method stub
		List<CartItem> list = shoppingCartRepository.getCartByUsername(username);
		shoppingCartRepository.deleteAll(list);
	}
}
