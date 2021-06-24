package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import model.SalesListDTO;

public class SalesRepository {
	@Autowired
	SqlSession sqlSession;
	private final String namespace = "mappers.salesMapper";
	private String statement;
	
	public List<SalesListDTO> salesList() {
		statement = namespace + ".salesList";
		return sqlSession.selectList(statement);
	}
}
