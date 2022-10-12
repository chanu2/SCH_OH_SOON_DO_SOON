package schjoin.SCH.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import schjoin.SCH.domain.Member;
import schjoin.SCH.dto.AddMemberDto;
import schjoin.SCH.repository.MemberRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    //회원가입
    @Transactional
    public Long createMember(AddMemberDto addMemberDto){
        Member member = Member.addMember(addMemberDto.getName(), addMemberDto.getSchoolNum(), addMemberDto.getPhoneNum());
        memberRepository.save(member);
        return member.getId();
    }


    //회원 한명 조회
    public Member findOne(Long memberId){
        return memberRepository.findOne(memberId);
    }
}