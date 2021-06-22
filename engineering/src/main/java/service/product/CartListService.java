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

public class CartListService {
	@Autowired
	ProductRepository productRepository;
	public void cartList(HttpSession session, Model model) {
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		String membId= authInfo.getUserId();
		/// 현재 접속한 membId의 <prod_no list>만 가져오기 위해서 
		List<String> list = productRepository.memCart(membId);
		List<ProductCartDTO> dtos = new ArrayList<ProductCartDTO>();
		for(String prodNo : list) {
			CartDTO dto = new CartDTO();
			// membId에 해당되는 prodNo를 하나씩 받아옴
			dto.setProdNo(prodNo);
			dto.setMembId(membId);
			// 현사용자의 상품번호 하나에 해당되는 데이터를 하나씩 받아와서 list에 저장
			ProductCartDTO productCartDTO = productRepository.cartList(dto);
			dtos.add(productCartDTO);			
		}
		model.addAttribute("list", dtos);
	}
}
