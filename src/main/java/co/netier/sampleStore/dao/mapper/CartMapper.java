package co.netier.sampleStore.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import co.netier.sampleStore.domain.Cart;
import co.netier.sampleStore.domain.CartItem;
import co.netier.sampleStore.service.ProductService;

public class CartMapper implements RowMapper<Cart> {
	private CartItemMapper cartItemMapper;
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	public CartMapper(NamedParameterJdbcTemplate jdbcTemplate, ProductService productService) {
		this.jdbcTemplate = jdbcTemplate;
		cartItemMapper = new CartItemMapper(productService);
	}

	@Override
	public Cart mapRow(ResultSet rs, int rowNum) throws SQLException {
		String id = rs.getString("cartID");
		Cart cart = new Cart(id);
		String sql = String.format("SELECT * FROM CART_ITEM WHERE cartID = '%s'", id);
		List<CartItem> cartItems = jdbcTemplate.query(sql, cartItemMapper);
		cart.setCartItems(cartItems);
		return cart;
	}

}
