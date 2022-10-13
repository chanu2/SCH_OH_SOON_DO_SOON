package schjoin.SCH.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import schjoin.SCH.domain.User;
import schjoin.SCH.domain.Participation;
import schjoin.SCH.domain.Reserve;
import schjoin.SCH.dto.ParticipationSportDto;
import schjoin.SCH.repository.UserRepository;
import schjoin.SCH.repository.ParticipationRepository;
import schjoin.SCH.repository.ReserveRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ParticipationService {

    private final UserRepository userRepository;
    private final ReserveRepository reserveRepository;
    private final ParticipationRepository participationRepository;

    //참가 하기//
    @Transactional
    public Long participation(ParticipationSportDto participationSportDto){
        //엔티티 조회
        User user = userRepository.findOne(participationSportDto.getMemberId());
        Reserve reserve = reserveRepository.findOne(participationSportDto.getReserveId());

        //참가자 만들기
        Participation participation = Participation.createParticipation(user,reserve);
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

    // 방정보 조회
    @Transactional
    public List<Participation> reserveInfo(Long reserveId){

        return participationRepository.findReserveInfo(reserveId);

    }



}