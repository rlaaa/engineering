package service.sales;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import model.SalesListDTO;
import repository.SalesRepository;

public class SalesListService {
	@Autowired
	SalesRepository salesRepository;
	public void salesList(Model model) {
		List<SalesListDTO> list = salesRepository.salesList();
		model.addAttribute("list", list);
	}

}
