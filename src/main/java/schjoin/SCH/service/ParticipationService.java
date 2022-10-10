package schjoin.SCH.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import schjoin.SCH.domain.Member;
import schjoin.SCH.domain.Participation;
import schjoin.SCH.domain.Reserve;
import schjoin.SCH.repository.MemberRepository;
import schjoin.SCH.repository.ParticipationRepository;
import schjoin.SCH.repository.ReserveRepository;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ParticipationService {

    private final MemberRepository memberRepository;
    private final ReserveRepository reserveRepository;
    private final ParticipationRepository participationRepository;

    //참가자//
    @Transactional
    public Long participation(Long memberId,Long reserveId){
        //엔티티 조회
        Member member = memberRepository.findOne(memberId);
        Reserve reserve = reserveRepository.findOne(reserveId);

        //참가자 만들기
        Participation participation = Participation.createParticipation(member,reserve);
        reserve.addCurrentNum();
        reserve.addParticipation(participation);

        //참가
        participationRepository.save(participation);
        return participation.getId();
    }

    //참가자 취소
    @Transactional
    public void cancelParticipation(Long participationId){

        //방 엔티티 조회
        Participation participation = participationRepository.findOne(participationId);
        //방 현재원 하나 줄이기
        participation.getReserve().subtractCurrentNum();

        participation.getReserve().subParticipation(participation);

        //예약 최소
        participationRepository.delete(participation.getId());

    }

}