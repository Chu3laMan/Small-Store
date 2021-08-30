package co.netier.sampleStore.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.netier.sampleStore.domain.Cart;
import co.netier.sampleStore.dto.CartDTO;
import co.netier.sampleStore.service.CartService;


@RestController
@RequestMapping(value = "/rest/cart")
public class CartRestController {
	
	@Autowired
	private CartService cartService;
	
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.CREATED)
	public Cart create(@RequestBody String cartDto) {
		return cartService.read(cartDto);
	}
	
	
	@RequestMapping(value = "/{cartId}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.OK)
	public void update(@PathVariable(value="cartId") String cartId, @RequestBody CartDTO cartDto) {
		cartDto.setCartID(cartId);
		cartService.update(cartId, cartDto);
	}
	
	@RequestMapping(value = "/{cartId}", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.OK)
	public void delete(@PathVariable(value = "cartId") String cartId) {
		cartService.delete(cartId);
	}
	
	@RequestMapping(value = "/add/{productId}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.OK)
	public void addItem(@PathVariable String productId, HttpSession session) {
		cartService.addItem(session.getId(), productId);
	}
	
	@RequestMapping(value = "/remove/{productId}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.OK)
	public void removeItem(@PathVariable String productId, HttpSession session) {
		cartService.removeItem(session.getId(), productId);
	}
	
	
	
	
	

}
