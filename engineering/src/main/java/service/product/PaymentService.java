package service.product;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import model.AuthInfo;
import model.PaymentDTO;
import repository.ProductRepository;

public class PaymentService {
	@Autowired
	ProductRepository productRepository;
	public void payment(String purchNo, String payPrice, 
						String payAccNum, String payCardBank, HttpSession session) {
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		String membId= authInfo.getUserId();
		PaymentDTO dto = new PaymentDTO();
		dto.setPayAccNum(payAccNum);
		dto.setPayCardBank(payCardBank);
		dto.setPayMethod("카드");
		dto.setPayPrice(payPrice);
		dto.setPurchNo(purchNo);
		productRepository.payInsert(dto);
	}
}
