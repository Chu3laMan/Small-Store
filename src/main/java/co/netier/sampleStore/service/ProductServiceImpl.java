package co.netier.sampleStore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.netier.sampleStore.dao.ProductRepository;
import co.netier.sampleStore.domain.Product;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<Product> getAllProducts() {
		return productRepository.getAllProducts();
	}

	@Override
	public void updateAllStock() {
		List<Product> allProducts = productRepository.getAllProducts();
		for(Product product : allProducts) {
			if(product.getUnitsInStock() < 500)
				productRepository.updateStock(product.getProductId(), product.getUnitsInStock()+1000);
		}
		
	}

	@Override
	public Product getProductByID(String productID) {
		return productRepository.getProductById(productID);
	}

	@Override
	public void addProduct(Product p) {
		productRepository.addProduct(p);
		
	}

}
