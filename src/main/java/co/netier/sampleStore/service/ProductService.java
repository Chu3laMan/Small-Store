package co.netier.sampleStore.service;

import java.util.List;

import co.netier.sampleStore.domain.Product;

public interface ProductService {
	
	List<Product> getAllProducts();
	void updateAllStock();
	Product getProductByID(String productID);
	public void addProduct(Product p);

}
