package service.member;

import org.springframework.beans.factory.annotation.Autowired;

import model.MemberDTO;
import repository.MemberRepository;

public class MemberPwChangeService {
	@Autowired
	MemberRepository memberRepository;
	public void pwOk(String userId, String newPw) {
		MemberDTO dto = new MemberDTO();
		dto.setMembId(userId);
		dto.setMembPw(newPw);
		memberRepository.pwChange(dto);
	}

}
