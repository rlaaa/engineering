package service.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import model.ProdReviewDTO;
import model.ProductDTO;
import repository.ProductRepository;

public class ProductInfoService {
	@Autowired
	ProductRepository productRepository;
	public void prodInfo(Model model, String prodNo) {
		ProductDTO dto = productRepository.prodInfo(prodNo);
		List<ProdReviewDTO> list = productRepository.prodReview(prodNo);
		model.addAttribute("list", list);
		model.addAttribute("dto", dto);
	}
}
