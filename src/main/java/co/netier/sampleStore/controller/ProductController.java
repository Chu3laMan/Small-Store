package co.netier.sampleStore.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;



import co.netier.sampleStore.dao.ProductRepository;
import co.netier.sampleStore.domain.Product;
import co.netier.sampleStore.service.ProductService;
import jakarta.validation.Valid;


@RequestMapping(value = "/webstore")
@Controller
public class ProductController {
	
	
	@Autowired
	private ProductService productService;
	
	
	
	

	@RequestMapping(value="/products", method = RequestMethod.GET)
	public String listAllProducts(Model model) throws IOException{
		model.addAttribute("products", productService.getAllProducts());
		return "products";
	}
	
	@RequestMapping("/product")
	public String getProductById(@RequestParam("id") String productId, Model model) {
		model.addAttribute("product", productService.getProductByID(productId));
		return "product";
	}
	
	@RequestMapping(value="/products/add", method = RequestMethod.POST)
	public String procesAndNewProductForm(@ModelAttribute("newProduct") @Valid Product newProduct , BindingResult result, HttpServletRequest request) {
		if(result.hasErrors())
			return "addProduct";
		productService.addProduct(newProduct);
		String[] supressedFields = result.getSuppressedFields();
		if(supressedFields.length > 0) {
			throw new RuntimeException("Attempting to bind disallowed fields: " + StringUtils.arrayToCommaDelimitedString(supressedFields));
		}
		return "redirect:/market/products";
	}
	
	 //below methods are used to add new product to the store, moreover, it used form backing bean in order to get information
	//from the HTML form elements in order to process them in the Controller
	@RequestMapping(value = "/products/add", method = RequestMethod.GET)
	public String getAddNewProductForm(Model model) {
		Product newProduct = new Product();
		model.addAttribute("newProduct", newProduct);
		return "addProduct";
	}
	
	
	
	
	//intializeBinder() method set up the fields which allowed for binding during submission
	@InitBinder("newProduct")
	public void intializeBinder(WebDataBinder binder) {
		binder.setAllowedFields("productId",
				"name",
				"unitPrice",
				"description",
				"manufacturer",
				"category",
				"unitsInStock",
				"unitsInOrder",
				"discontinued",
				"condition",
				"language");
	}
	
	
	
}
