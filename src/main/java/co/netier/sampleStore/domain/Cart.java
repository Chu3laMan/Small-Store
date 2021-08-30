package co.netier.sampleStore.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.function.Function;

public class Cart implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3747101576507633886L;
	private String cartID;
	private List<CartItem> cartItems;
	private BigDecimal totalAmount;
	
	public Cart(String cardID) {
		this.cartID = cardID;
	}

	/**
	 * @return the cartID
	 */
	public String getCartID() {
		return cartID;
	}

	/**
	 * @param cartID the cartID to set
	 */
	public void setCartID(String cartID) {
		this.cartID = cartID;
	}

	/**
	 * @return the cartItems
	 */
	public List<CartItem> getCartItems() {
		return cartItems;
	}

	/**
	 * @param cartItems the cartItems to set
	 */
	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}

	/**
	 * @return the totalAmount
	 */
	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	/**
	 * @param totalAmount the totalAmount to set
	 */
	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	public void updateTotalAmount() {
		Function<CartItem, BigDecimal> totalMapper = cartItem -> cartItem.getTotalPrice();
		BigDecimal grandTotal = cartItems.stream().map(totalMapper).reduce(BigDecimal.ZERO, BigDecimal::add);
		this.setTotalAmount(grandTotal);
	}
	
	public CartItem getItemByProductId(String productID) {
		return cartItems.stream().filter(cartItem -> cartItem.getProduct().getProductId().equals(productID)).findAny().orElse(null);
	}
	

}
