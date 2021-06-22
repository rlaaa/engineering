package service.product;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import model.AuthInfo;
import model.CartDTO;
import repository.ProductRepository;

public class CartQtyDownService {
	@Autowired
	ProductRepository productRepository;
	public void cartQtyDown(String prodNo, String prodPrice, HttpSession session) {
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		String membId = authInfo.getUserId();
		CartDTO dto = new CartDTO();
		dto.setProdNo(prodNo);
		dto.setCartPrice(prodPrice);
		dto.setMembId(membId);
		productRepository.cartQtyDown(dto);
	}
}
