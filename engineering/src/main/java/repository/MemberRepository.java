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
	

	public MemberDTO memInfo(String memId) {
		statement = namespace + ".memberInfo";
		return sqlSession.selectOne(statement, memId);
	}
	
	public void pwChange(MemberDTO dto) {
		statement = namespace + ".pwChange";
		sqlSession.update(statement, dto);
	}
	
	public void memDel(String memId) {
		statement = namespace + ".memberDelete";
		sqlSession.delete(statement, memId);
		
	}
	public void memUpdate(MemberDTO dto) {
		statement = namespace + ".memberUpdate";
		sqlSession.update(statement, dto);
	}
	
	public List<MemberDTO> memList() {
		statement = namespace + ".memberList";
		return sqlSession.selectList(statement);
	}

	public void memberInsert(MemberDTO dto) {
		statement = namespace + ".memberInsert";
		sqlSession.insert(statement, dto);
	}



	

}
