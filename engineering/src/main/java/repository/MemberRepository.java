package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import model.MemberDTO;

public class MemberRepository {
	@Autowired
	SqlSession sqlSession;
	private final String namespace ="mappers.memberMapper";
	private String statement;
	
	public List<MemberDTO> memList() {
		statement = namespace + ".memberList";
		return sqlSession.selectList(statement);
	}
	
	public void memberInsert(MemberDTO dto) {
		statement = namespace + ".memberInsert";
		sqlSession.insert(statement, dto);
	}
	

}
