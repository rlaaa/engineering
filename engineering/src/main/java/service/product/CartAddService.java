package service.product;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import model.AuthInfo;
import model.CartDTO;
import repository.ProductRepository;

public class CartAddService {
	@Autowired
	ProductRepository productRepository;
	public void cartAdd(String prodNo, String cartQty, String prodPrice, 
						String cateNum, HttpSession session) {
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		String membId = authInfo.getUserId();
		CartDTO dto = new CartDTO();
		dto.setCartQty(cartQty);
		dto.setCateNum(cateNum);
		dto.setMembId(membId);
		dto.setProdNo(prodNo);
		dto.setCartPrice(Integer.toString(Integer.parseInt(prodPrice) * Integer.parseInt(cartQty)));
		productRepository.cartAdd(dto);
	}
}
