package schjoin.SCH.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import schjoin.SCH.domain.Member;
import schjoin.SCH.domain.Participation;
import schjoin.SCH.domain.Reserve;
import schjoin.SCH.domain.Sport;
import schjoin.SCH.dto.CreateReserveDto;
import schjoin.SCH.dto.UpdateReserveDto;
import schjoin.SCH.repository.MemberRepository;
import schjoin.SCH.repository.ParticipationRepository;
import schjoin.SCH.repository.ReserveRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ReserveService {

    private final MemberRepository memberRepository;
    private final ReserveRepository reserveRepository;

    private final ParticipationRepository participationRepository;


    //구장 생성
    @Transactional
    public Long reserve(CreateReserveDto createReserveDto){

        //엔티티 조회
        Member member = memberRepository.findOne(createReserveDto.getMemberId());

        // 경기 생성
        Reserve reserve = Reserve.createReserve(member, createReserveDto.getTitle(),
                createReserveDto.getExplanation(),
                createReserveDto.getRecruitmentNum(),
                createReserveDto.getSport(),
                createReserveDto.getEndT(),
                createReserveDto.getStartT(),
                createReserveDto.getReserveDate(),
                createReserveDto.getPlace(),
                createReserveDto.getGender());

        //경기 저장
        reserveRepository.save(reserve);
        return reserve.getId();
    }


    // 구장 삭제
    @Transactional
    public void cancelReserve(Long reserveId){

        // 경기 엔티티 조회
        Reserve reserve = reserveRepository.findOne(reserveId);


        // or
        reserveRepository.delete(reserve);


        // 경기 예약 취소

    }


    // 구장 업데이트
   @Transactional
    public Long updateReserve(Long reserveId, UpdateReserveDto reserveDto){

        Reserve reserve = reserveRepository.findOne(reserveId);

        reserve.setReserveDate(reserveDto.getReserveDate());
        reserve.setEndT(reserveDto.getEndT());
        reserve.setStartT(reserveDto.getStartT());

        reserve.setSport(reserveDto.getSport());

        reserve.setTitle(reserveDto.getTitle());
        reserve.setExplanation(reserveDto.getExplanation());
        reserve.setPlace(reserveDto.getPlace());
        reserve.setGender(reserveDto.getGender());

       return reserveId;
   }


   // 오늘 날짜 모든 경기 보여주기

    @Transactional
    public List<Reserve> todayMatch(LocalDate todayDate){
        return reserveRepository.findByToday(todayDate);

    }

    //구장에 관련된 정보 보여주기
    





    // 원하는 날짜,스포츠 정렬해서 경기들 보여 주기
    @Transactional
    public List<Reserve> sportDate(LocalDate day ,Sport sport){

        return reserveRepository.findBySportDate(day,sport);

    }

    @Transactional
    public Reserve findOne(Long reserveId){
        return reserveRepository.findOne(reserveId);
    }





}