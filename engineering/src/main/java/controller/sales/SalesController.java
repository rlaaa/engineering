package controller.sales;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import service.sales.SalesListService;

@Controller
@RequestMapping("sales")
public class SalesController {
	@Autowired
	SalesListService salesListService;
	@RequestMapping("salesList")
	public String salesList(Model model) {
		salesListService.salesList(model);
		return "sales/salesList";
	}

}
