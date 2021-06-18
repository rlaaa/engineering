package service.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import model.ProductDTO;
import repository.ProductRepository;

public class ProductListService {
	@Autowired
	ProductRepository productRepository;
	public void prodList(Model model) {
		List<ProductDTO> list = productRepository.prodList();
		model.addAttribute("prodList", list);
		
	}

}
