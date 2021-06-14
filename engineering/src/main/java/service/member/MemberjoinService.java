package service.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import command.MemberCommand;
import model.MemberDTO;
import repository.MemberRepository;

public class MemberjoinService {
	@Autowired
	BCryptPasswordEncoder bcryptPasswordEncoder;
	@Autowired
	MemberRepository memberRepository;
	public void memberInsert(MemberCommand memberCommand) {
		MemberDTO dto = new MemberDTO();
		dto.setDetailAddr(memberCommand.getDetailAddr());
		dto.setMembAddr(memberCommand.getMembAddr());
		dto.setMembBirth(memberCommand.getMembBirth());
		dto.setMembConfirm(memberCommand.getMembConfirm());
		dto.setMembEmail(memberCommand.getMembEmail());
		dto.setMembGender(memberCommand.getMembGender());
		dto.setMembId(memberCommand.getMembId());
		dto.setMembName(memberCommand.getMembName());
		dto.setMembPhoneNumber(memberCommand.getMembPhoneNumber());
		dto.setMembPw(bcryptPasswordEncoder.encode(memberCommand.getMembPw()));
		dto.setPostNumber(memberCommand.getPostNumber());
		memberRepository.memberInsert(dto);
	}

}
