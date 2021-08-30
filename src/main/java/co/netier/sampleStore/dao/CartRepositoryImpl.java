package co.netier.sampleStore.dao;

import java.awt.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import co.netier.sampleStore.dao.mapper.CartMapper;
import co.netier.sampleStore.domain.Cart;
import co.netier.sampleStore.domain.CartItem;
import co.netier.sampleStore.domain.Product;
import co.netier.sampleStore.dto.CartDTO;
import co.netier.sampleStore.dto.CartItemDTO;
import co.netier.sampleStore.service.ProductService;

public class CartRepositoryImpl implements CartRepository {
	
	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParamaterJdbcTemplate;
	
	@Autowired
	private ProductService productService;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
		namedParamaterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
	}
	
	

	

	@Override
	public void create(CartDTO cartDto) {
		String query = "INSERT INTO CART (cartID) VALUES (:id)";
		Map<String, Object> cartParam = new HashMap<String, Object>();
		cartParam.put("id", cartDto.getCartID());
		jdbcTemplate.update(query, cartParam);
		
		cartDto.getCartItems().stream().forEach(cartItemDto -> { 
			Product productById = productService.getProductByID(cartItemDto.getProductID());
			
			String query2 = "INSERT INTO CART_ITEM (cartItemID, quantity, PRODUCT_ID, CART_cartID) "
					+ "VALUES (:id, :quantity, :product_id, :cart_id)";
			Map<String, Object> cartItemsParam = new HashMap<String, Object>();
			cartItemsParam.put("id", cartItemDto.getProductID());
			cartItemsParam.put("product_id", productById.getProductId());
			cartItemsParam.put("cart_id", cartDto.getCartID());
			cartItemsParam.put("quantity", cartItemDto.getQuantity());
			namedParamaterJdbcTemplate.update(query2, cartParam);
			
		});
		
		
		
		
		
		
		
	}

	@Override
	public Cart read(String id) {
		String query = "SELECT * FROM CART WHERE cartID = :id";
		Map<String, Object> params = new HashMap<>();
		params.put("id", id);
		CartMapper cartMapper = new CartMapper(namedParamaterJdbcTemplate, productService);
		try {
			return namedParamaterJdbcTemplate.queryForObject(query, params, cartMapper);
		}catch(EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public void update(String id, CartDTO cartDto) {
		java.util.List<CartItemDTO> cartItems = cartDto.getCartItems();
		for(CartItemDTO cartItem : cartItems)
		{
			String query = "UPDATE CART_ITEM SET quantity = :quantity, PRODUCT_ID =: productId WHERE ID = :id AND cartID = :cart_id";
			Map<String, Object> params = new HashMap<>();
			params.put("id", cartItem.getProductID());
			params.put("quantity", cartItem.getQuantity());
			params.put("productId", cartItem.getProductID());
			params.put("cartID", id);
			namedParamaterJdbcTemplate.update(query, params);
		}
	}

	@Override
	public void delete(String id) {
		String query = "DELETE FROM CART_ITEM WHERE cartitemID = :id";
		String query2 = "DELECT FROM CART WHERE cartID = :id";
		Map<String, Object> params = new HashMap<>();
		params.put("id", id);
		namedParamaterJdbcTemplate.update(query, params);
		namedParamaterJdbcTemplate.update(query2, params);
		
	}

	@Override
	public void addItem(String cartId, String productId) {
		String sql = null;
		Cart cart = null;
		cart = read(cartId);
		CartItemDTO newCartItemDto = null;
		if(cart == null) {
			newCartItemDto = new CartItemDTO();
			newCartItemDto.setCartitemID(cartId + productId);
			newCartItemDto.setProductID(productId);
			newCartItemDto.setQuantity(1);
			CartDTO newCartDto = new CartDTO(cartId);
			newCartDto.addCartItem(newCartItemDto);
			create(newCartDto);
			return;
		}
		Map<String, Object> cartItemsParams = new HashMap<String, Object>();
		if(cart.getItemByProductId(productId) == null) {
			sql = "INSERT INTO CART_ITEM (cartitemID, quantity, PRODUCT_ID, CART_cartID)"
					+ "VALUES (:id, :quantity, :productId, :cartId)";
			cartItemsParams.put("id", cartId+productId);
			cartItemsParams.put("quantity", 1);
			
		}else {
			sql = "UPDATE CART_ITEM SET quantity = :quantity WHERE cartitemID = :cartId AND PRODUCT_ID = :productId";
			CartItem existingItem = cart.getItemByProductId(productId);
			cartItemsParams.put("id", existingItem.getCartitemID());
			cartItemsParams.put("quantity", existingItem.getQuantity() + 1);
		}
		cartItemsParams.put("productId", productId);
		cartItemsParams.put("cartId", cartId);
		namedParamaterJdbcTemplate.update(sql, cartItemsParams);
			
	}

	@Override
	public void removeItem(String cardId, String productId) {
		String query = "DELETE FROM CART_ITEM WHERE PRODUCT_ID = :productId AND CART_cartID = :id";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", cardId);
		params.put("productId", productId);
		namedParamaterJdbcTemplate.update(query, params);
	}

}
