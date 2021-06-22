package service.product;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import model.AuthInfo;
import model.CartDTO;
import model.ProductCartDTO;
import repository.ProductRepository;

public class ProdBuyService {
	@Autowired
	ProductRepository productRepository;
	public void prodBuy(HttpSession session, String [] prodCk, Model model) {
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		String membId= authInfo.getUserId();
		List<ProductCartDTO> list = new ArrayList<ProductCartDTO>();
		for(String prodNo : prodCk) {
			CartDTO dto = new CartDTO();
			dto.setMembId(membId);
			dto.setProdNo(prodNo);
			ProductCartDTO dto1 = productRepository.cartList(dto);
			list.add(dto1);
		}
		model.addAttribute("list", list);
		
	}
}
