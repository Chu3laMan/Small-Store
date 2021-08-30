package co.netier.sampleStore.dto;

import java.io.Serializable;

public class CartItemDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2042962930970214934L;
	private String cartitemID;
	private String productID;
	private int quantity;
	
	public CartItemDTO() {}
	
	
	/**
	 * @return the cartitemID
	 */
	public String getCartitemID() {
		return cartitemID;
	}
	/**
	 * @param cartitemID the cartitemID to set
	 */
	public void setCartitemID(String cartitemID) {
		this.cartitemID = cartitemID;
	}
	/**
	 * @return the productID
	 */
	public String getProductID() {
		return productID;
	}
	/**
	 * @param productID the productID to set
	 */
	public void setProductID(String productID) {
		this.productID = productID;
	}
	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}
	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
