package controller.prod;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import command.GoodsOrderCommand;
import command.ProductCommand;
import service.product.CartAddService;
import service.product.CartListService;
import service.product.CartQtyDownService;
import service.product.GoodsOrderService;
import service.product.PaymentService;
import service.product.ProdBuyService;
import service.product.ProductAutoNumService;
import service.product.ProductDeleteService;
import service.product.ProductInfoService;
import service.product.ProductJoinService;
import service.product.ProductListService;
import service.product.ProductModifyService;
import service.product.PurchaseListService;
import service.product.ReviewModifyService;
import service.product.ReviewUpdateService;
import service.product.ReviewWriteService;

@Controller
@RequestMapping("prod")
public class ProdController {
	@Autowired
	ProductAutoNumService productAutoNumService;
	@Autowired
	ProductListService productListService;
	@Autowired
	ProductInfoService productInfoService;
	@Autowired
	ProductModifyService productModifyService;
	@Autowired
	ProductDeleteService productDeleteService;
	@Autowired
	CartAddService cartAddService;
	@Autowired
	CartListService cartListService;
	@Autowired
	CartQtyDownService cartQtyDownService;
	@Autowired
	ProdBuyService prodBuyService;
	@Autowired
	GoodsOrderService goodsOrderService;
	@Autowired
	PurchaseListService purchaseListService;
	@Autowired
	PaymentService paymentService;
	@Autowired
	ReviewWriteService reviewWriteService;
	@Autowired
	ReviewModifyService reviewModifyService;
	@Autowired
	ReviewUpdateService reviewUpdateService;
	
	@RequestMapping("goodsReviewUpdate")
	public String goodsReviewUpdate(@RequestParam(value="purchNo") String purchNo, 
			  				@RequestParam(value="prodNo") String prodNo, 
			  				@RequestParam(value="prodName") String prodName,
			  				Model model) {
		reviewUpdateService.reviewUpdate(prodNo, purchNo, prodName, model);
		return "product/reviewUpdate";
	}
	@RequestMapping("goodsReviewUpdateOk")
	public String goodsReviewUpdateOk(@RequestParam(value="purchNo") String purchNo, 
			 				@RequestParam(value="prodNo") String prodNo, 
			 				@RequestParam(value="reviewContent") String reviewContent) {
		reviewModifyService.reviewUpdate(prodNo, purchNo, reviewContent);
		return "redirect:purchCon";
	}
	@RequestMapping("goodsReview")
	public String goodsReview(@RequestParam(value="purchNo") String purchNo, 
							  @RequestParam(value="prodNo") String prodNo, 
							  @RequestParam(value="prodName") String prodName, Model model) {
		model.addAttribute("purchNo", purchNo);
		model.addAttribute("prodNo", prodNo);
		model.addAttribute("prodName", prodName);
		return "product/prodReview";
	}
	@RequestMapping("reviewOk")
	public String reviewOk(@RequestParam(value="purchNo") String purchNo, 
						   @RequestParam(value="prodNo") String prodNo, 
						   @RequestParam(value="reviewContent") String reviewContent, Model model) {
		reviewWriteService.reviewWrite(prodNo, purchNo, reviewContent);
		return "redirect:purchCon";
	}
	@RequestMapping("doPayment")
	public String doPayment(@RequestParam(value="purchNo") String purchNo, 
							@RequestParam(value="payPrice") String payPrice, 
							@RequestParam(value="payAccNum") String payAccNum, 
							@RequestParam(value="payCardBank") String payCardBank,
							// RequestParam ?????? ????????? ?????????????????? command ??????????????? ??????
							HttpSession session) {
		paymentService.payment(purchNo, payPrice, payAccNum, payCardBank, session);
		return "redirect:purchCon";
	}
	@RequestMapping("paymentOk")
	public String paymentOk(@RequestParam(value="purchNo") String purchNo, 
							@RequestParam(value="payPrice") String payPrice, Model model) {
		model.addAttribute("purchNo", purchNo);
		model.addAttribute("payPrice", payPrice);
		return "product/payment";
	}
	@RequestMapping("purchCon")
	public String purchCon(HttpSession session, Model model) {
		purchaseListService.purchList(session, model);
		return "product/purchCon";
	}
	@RequestMapping("goodsOrder")
	public String goodsOrder(GoodsOrderCommand goodsOrderCommand, HttpSession session) {
		String purchNo = goodsOrderService.goodsOrder(goodsOrderCommand, session);
		return "redirect:paymentOk?purchNo="+purchNo+"&payPrice="+goodsOrderCommand.getPurchTotal();
	}
	
	@RequestMapping("prodBuy")
	public String prodBuy(@RequestParam(value="prodCk") String [] prodCk, Model model,
						  HttpSession session) {
		prodBuyService.prodBuy(session, prodCk, model);
		return "product/order";
	}
	
	@RequestMapping("goodsCartQtyDown")
	public String goodsCartQtyDown(@RequestParam(value="prodNo") String prodNo,
								   @RequestParam(value="prodPrice") String prodPrice,
									HttpSession session) {
		cartQtyDownService.cartQtyDown(prodNo, prodPrice, session);
		return "redirect:cartList";
	}
	
	@RequestMapping("prodInfo")
	public String prodInfo(@RequestParam(value="prodNo") String prodNo, Model model) {
		productInfoService.prodInfo(model, prodNo);
		return "product/prodInfo";
	}
	@RequestMapping("cartAdd")
	public String cartAdd(@RequestParam(value="prodNo") String prodNo, @RequestParam(value="cartQty") String cartQty,
						  @RequestParam(value="prodPrice") String prodPrice, @RequestParam(value="cateNum") String cateNum,
						  Model model, HttpSession session) {
		cartAddService.cartAdd(prodNo, cartQty, prodPrice, cateNum, session);
		return "redirect:cartList";
	}
	@RequestMapping("cartList")
	public String cartList(Model model, HttpSession session) {
		cartListService.cartList(session, model);
		return "product/cartList";
	}
	
	@RequestMapping("prodDel")
	public String prodDel(@RequestParam(value="prodNo") String prodNo, HttpSession session) {
		productDeleteService.prodDel(prodNo, session);
		return "redirect:prodList";
	}
	
	@RequestMapping(value="prodModifyOk", method=RequestMethod.POST)
										// ??????????????? method ?????? ??? ???????????? ???
	public String prodModifyOk(ProductCommand productCommand) {
		productModifyService.prodUpdate(productCommand);
		return "redirect:prodList";
	}
	@RequestMapping("prodUpdate")
	public String prodUpdate(@RequestParam(value="prodNo") String prodNo, Model model) {
		productInfoService.prodInfo(model, prodNo);
		return "product/prodModify";
	}
	@RequestMapping("prodList")
	public String prodList(Model model) {
		productListService.prodList(model);
		return "product/productList";
	}
	@RequestMapping("prodJoin")
	public String prodJoin(Model model) {
		productAutoNumService.autoNum(model);
		return "product/productForm";
	}
	@Autowired
	ProductJoinService productJoinService;
	@RequestMapping("prodJoinOk")
	public String prodJoinOk (ProductCommand productCommand, HttpSession session) {
		productJoinService.prodJoin(productCommand, session);
		return "redirect:prodList";
	}

}
