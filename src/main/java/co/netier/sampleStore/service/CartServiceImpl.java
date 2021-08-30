package co.netier.sampleStore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.netier.sampleStore.dao.CartRepository;
import co.netier.sampleStore.domain.Cart;
import co.netier.sampleStore.dto.CartDTO;

@Service
public class CartServiceImpl implements CartService {
	
	@Autowired
	private CartRepository cartRepository;

	@Override
	public void create(CartDTO cartDto) {
		cartRepository.create(cartDto);
		
	}

	@Override
	public Cart read(String cartId) {
		return cartRepository.read(cartId);
	}

	@Override
	public void update(String cartId, CartDTO cartDto) {
		cartRepository.update(cartId, cartDto);
		
	}

	@Override
	public void delete(String id) {
		cartRepository.delete(id);
		
	}

	@Override
	public void addItem(String cartId, String productId) {
		cartRepository.addItem(cartId, productId);
		
	}

	@Override
	public void removeItem(String cartId, String productId) {
		cartRepository.read(productId);
		
	}

}
