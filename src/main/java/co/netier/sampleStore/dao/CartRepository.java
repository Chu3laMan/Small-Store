package co.netier.sampleStore.dao;

import co.netier.sampleStore.domain.Cart;
import co.netier.sampleStore.dto.CartDTO;

public interface CartRepository {
	
	void create(CartDTO cartDTO);
	Cart read(String cartId);
	void update(String id, CartDTO cartDTO);
	void delete(String id);
	void addItem(String cartId, String productId);
	void removeItem(String cardId, String productId);
	

}
