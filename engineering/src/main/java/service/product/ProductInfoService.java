package service.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import model.ProductDTO;
import repository.ProductRepository;

public class ProductInfoService {
	@Autowired
	ProductRepository productRepository;
	public void prodInfo(Model model, String prodNo) {
		ProductDTO dto = productRepository.prodInfo(prodNo);
		model.addAttribute("dto", dto);
	}
}
