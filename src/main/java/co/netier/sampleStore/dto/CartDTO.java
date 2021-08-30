package co.netier.sampleStore.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CartDTO implements Serializable {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2322397011183153079L;
	private String cartID;
	private List<CartItemDTO> cartItems;
	
	public CartDTO() {}
	
	public CartDTO(String cartID) {
		this.cartID = cartID;
		cartItems = new ArrayList<>();
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
	public List<CartItemDTO> getCartItems() {
		return cartItems;
	}

	/**
	 * @param cartItems the cartItems to set
	 */
	public void setCartItems(List<CartItemDTO> cartItems) {
		this.cartItems = cartItems;
	}
	
	
	public void addCartItem(CartItemDTO cartItemDTO) {
		this.cartItems.add(cartItemDTO);
	}
	
	

}
