package service.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import model.ReviewDTO;
import repository.ProductRepository;

public class ReviewUpdateService {
	@Autowired
	ProductRepository productRepository;
	public void reviewUpdate(String prodNo, String purchNo, 
							 String prodName, Model model) {
		ReviewDTO dto = new ReviewDTO();
		dto.setProdNo(prodNo);
		dto.setPurchNo(purchNo);
		dto = productRepository.reviewSelect(dto);
		model.addAttribute("dto", dto);
		model.addAttribute("prodName", prodName);
		
	}
}
