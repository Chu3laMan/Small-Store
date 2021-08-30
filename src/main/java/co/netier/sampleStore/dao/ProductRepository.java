package co.netier.sampleStore.dao;

import java.util.List;

import co.netier.sampleStore.domain.Product;

public interface ProductRepository {
	
	List<Product> getAllProducts();
    Product getProductById(String productID);
	void updateStock(String productId, long nOfUnits);
	public void addProduct(Product p);

}
