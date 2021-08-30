package co.netier.sampleStore.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class CartItem implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6873938320757249311L;
	private String cartitemID;
	private Product product;
	private int quantity;
	private BigDecimal totalPrice;
	
	public CartItem() {}

	public CartItem(String cartitemID) {
		super();
		this.cartitemID = cartitemID;
	}

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
	 * @return the product
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * @param product the product to set
	 */
	public void setProduct(Product product) {
		this.product = product;
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
	
	public BigDecimal getTotalPrice() {
		this.updateTotalPrice();
		return totalPrice;
	}
	
	public void updateTotalPrice() {
		totalPrice = this.product.getUnitPrice().multiply(new BigDecimal(this.quantity));
	}
	
	
	

}
