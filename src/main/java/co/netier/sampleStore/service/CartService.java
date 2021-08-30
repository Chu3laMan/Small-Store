package co.netier.sampleStore.service;

import co.netier.sampleStore.dto.CartDTO;
import co.netier.sampleStore.domain.*;

public interface CartService {
	
	void create(CartDTO cartDto);
	Cart read(String cartDto);
	void update(String cartId, CartDTO cartDto);
	void delete(String id);
	void addItem(String cartId, String productId);
	void removeItem(String cartId, String productId);
	

}
