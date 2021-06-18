package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import model.CateDTO;
import model.ProductDTO;

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
}
