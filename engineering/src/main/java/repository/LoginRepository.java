package repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import model.AuthInfo;

public class LoginRepository {
	@Autowired
	SqlSession sqlSession;
	private final String namespace = "mappers.loginMapper";
	private String statement;
	public AuthInfo login(String loginId) {
		statement = namespace + ".loginSelect";
		return sqlSession.selectOne(statement, loginId);
	}

}
