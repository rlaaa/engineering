package service.product;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import command.GoodsOrderCommand;
import model.AuthInfo;
import model.CartDTO;
import model.PurchaseDTO;
import repository.ProductRepository;

public class GoodsOrderService {
	@Autowired
	ProductRepository productRepository;
	public String goodsOrder(GoodsOrderCommand goodsOrderCommand, HttpSession session) {
		   //구매번호를 리턴
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		String membId = authInfo.getUserId();
		PurchaseDTO dto = new PurchaseDTO();
		dto.setMembId(membId);
		dto.setPurchAddr(goodsOrderCommand.getPurchAddr());
		dto.setPurchMsg(goodsOrderCommand.getPurchMsg());
		dto.setPurchPhoneNumber(goodsOrderCommand.getPurchPhoneNumber());
		dto.setPurchReceiver(goodsOrderCommand.getPurchReceiver());
		dto.setPurchTotal(goodsOrderCommand.getPurchTotal());
		/// purchNo를 날짜값으로 사용하기 위해서 (날짜를 구매번호로 사용)
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		String purchNo = df.format(new Date());
		dto.setPurchNo(purchNo);
		productRepository.purchInsert(dto);
		/// 카트(cart) 테이블에 있는 제품정보를 구매리스트(purchase_list) 테이블에 복사하기 위해서
		String [] prodNums = goodsOrderCommand.getProdNums().split(",");
		for(String prodNum : prodNums) {
			CartDTO d = new CartDTO();
			d.setPurchNo(purchNo);
			d.setMembId(membId);
			d.setProdNo(prodNum);
			productRepository.purchListInsert(d);
			/// 구매가 완료되면 구매한 물품은 카트에서 삭제
			productRepository.cartProdDel(d);
		}
		return purchNo;
	}
}
