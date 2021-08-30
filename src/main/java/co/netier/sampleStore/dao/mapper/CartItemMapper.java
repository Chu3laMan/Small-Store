package co.netier.sampleStore.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import co.netier.sampleStore.domain.CartItem;
import co.netier.sampleStore.service.ProductService;

public class CartItemMapper implements RowMapper<CartItem> {
	private ProductService productService;
	
	public CartItemMapper(ProductService productService) {
		this.productService = productService;
	}

	@Override
	public CartItem mapRow(ResultSet rs, int rowNum) throws SQLException {
		CartItem cartItem = new CartItem(rs.getString("cartitemID"));
		cartItem.setProduct(productService.getProductByID(rs.getString("PRODUCT_ID")));
		cartItem.setQuantity(rs.getInt("quantity"));
		return cartItem;
		
	}

}
