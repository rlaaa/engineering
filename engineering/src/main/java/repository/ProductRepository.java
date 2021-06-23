package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import model.CartDTO;
import model.CateDTO;
import model.PaymentDTO;
import model.ProductCartDTO;
import model.ProductDTO;
import model.PurchListDTO;
import model.PurchaseDTO;

public class ProductRepository {
	@Autowired
	SqlSession sqlSession;
	private final String namespace ="mappers.productMapper";
	private String statement;
	
	public ProductDTO prodInfo(String prodNo) {
		statement = namespace + ".prodInfo";
		return sqlSession.selectOne(statement, prodNo);
	}
	
	public void prodUpdate(ProductDTO dto) {
		statement = namespace + ".prodUpdate";
		sqlSession.update(statement, dto);
	}
	
	public void prodInsert(ProductDTO dto) {
		statement = namespace + ".prodInsert";
		sqlSession.insert(statement, dto);
	}
	
	public List<CateDTO> catList() {
		statement = namespace + ".catList";
		return sqlSession.selectList(statement);
	}
	
	public String autoNum() {
		statement = namespace + ".autoNum";
		return sqlSession.selectOne(statement);
	}

	public List<ProductDTO> prodList() {
		statement = namespace + ".prodList";
		return sqlSession.selectList(statement);
						// 리스트를 반환하고자 할 때 selectList 사용
	}

	public void prodDel(String prodNo) {
		statement = namespace + ".prodDelete";
		sqlSession.delete(statement, prodNo);
	}

	public void cartAdd(CartDTO dto) {
		statement = namespace + ".cartInsert";
		sqlSession.insert(statement, dto);
		
	}

	public List<String> memCart(String membId) {
		statement = namespace + ".memCart";
		return sqlSession.selectList(statement, membId);
	}

	public ProductCartDTO cartList(CartDTO dto) {
		statement = namespace + ".cartList";
		return sqlSession.selectOne(statement, dto);
	}

	public void cartQtyDown(CartDTO dto) {
		statement = namespace + ".cartQtyDown";
		sqlSession.update(statement, dto);
	}

	public void purchInsert(PurchaseDTO dto) {
		statement = namespace + ".purchInsert";
		sqlSession.insert(statement, dto);
	}

	public void purchListInsert(CartDTO d) {
		statement = namespace + ".purchListInsert";
		sqlSession.insert(statement, d);
	}

	public void cartProdDel(CartDTO d) {
		statement = namespace + ".cartProdDel";
		sqlSession.delete(statement, d);		
	}

	public List<PurchListDTO> purchList(String membId) {
		statement = namespace + ".purchList";
		return sqlSession.selectList(statement, membId);
	}

	public void payInsert(PaymentDTO dto) {
		statement = namespace + ".payInsert";
		sqlSession.insert(statement, dto);
		
	}
	
	


}
