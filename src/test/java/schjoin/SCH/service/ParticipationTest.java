package schjoin.SCH.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import schjoin.SCH.domain.Member;
import schjoin.SCH.domain.Reserve;
import schjoin.SCH.domain.Sport;
import schjoin.SCH.dto.UpdateReserveDto;
import schjoin.SCH.repository.ReserveRepository;

import javax.persistence.EntityManager;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@RunWith(SpringRunner.class)
@Transactional
@Rollback(value = false)
public class ParticipationTest {

    @Autowired MemberService memberService;

    @Autowired ParticipationService participationService;

    @Autowired ReserveService reserveService;

    @Autowired EntityManager em;
    
    @Autowired
    ReserveRepository reserveRepository;


    @Test
    public void 경기생성_참여() throws Exception{

    //given

        Member member = new Member();
        Member member1 = new Member();
        Member member2 = new Member();
        Member member3 = new Member();
        Member member4 = new Member();
        Member member5 = new Member();
        Member member6 = new Member();
        Member member7 = new Member();


        member.setName("김찬우");
        member1.setName("이훈일");
        member2.setName("이건희");
        member3.setName("조준장");
        member4.setName("왕세준");
        member5.setName("이기범");
        member6.setName("하재은");
        member7.setName("은혜");


        member.setPhoneNum("01082527933");
        member1.setPhoneNum("01082567865");
        member2.setPhoneNum("0108252678");
        member3.setPhoneNum("01025279678");
        member4.setPhoneNum("0108259787");
        member5.setPhoneNum("01082597871");
        member6.setPhoneNum("01082597873");
        member7.setPhoneNum("01082597875");

        member.setSchoolNum("12");
        member1.setSchoolNum("123");
        member2.setSchoolNum("1234");
        member3.setSchoolNum("123456");
        member4.setSchoolNum("1212345");
        member5.setSchoolNum("11235");
        member6.setSchoolNum("54664");
        member7.setSchoolNum("5657");

        em.persist(member);
        em.persist(member1);
        em.persist(member2);
        em.persist(member3);
        em.persist(member4);
        em.persist(member5);
        em.persist(member6);
        em.persist(member7);


        Long reserve = reserveService.reserve(member.getId(), "축구", "나와",12,Sport.SOCCER,
                LocalTime.of(20,30),
                LocalTime.of(22, 30),
                LocalDate.of(2000, 1, 3));


        participationService.participation(member2.getId(),reserve);
        participationService.participation(member3.getId(),reserve);
        participationService.participation(member4.getId(),reserve);
        participationService.participation(member5.getId(),reserve);

        em.flush();
        em.clear();





    }

    @Test
    public void 참여_취소() throws Exception{

        //given

        Member member = new Member();
        Member member1 = new Member();
        Member member2 = new Member();
        Member member3 = new Member();
        Member member4 = new Member();
        Member member5 = new Member();
        Member member6 = new Member();
        Member member7 = new Member();


        member.setName("김찬우");
        member1.setName("이훈일");
        member2.setName("이건희");
        member3.setName("조준장");
        member4.setName("왕세준");
        member5.setName("이기범");
        member6.setName("하재은");
        member7.setName("은혜");


        member.setPhoneNum("01082527933");
        member1.setPhoneNum("01082567865");
        member2.setPhoneNum("0108252678");
        member3.setPhoneNum("01025279678");
        member4.setPhoneNum("0108259787");
        member5.setPhoneNum("01082597871");
        member6.setPhoneNum("01082597873");
        member7.setPhoneNum("01082597875");

        member.setSchoolNum("12");
        member1.setSchoolNum("123");
        member2.setSchoolNum("1234");
        member3.setSchoolNum("123456");
        member4.setSchoolNum("1212345");
        member5.setSchoolNum("11235");
        member6.setSchoolNum("54664");
        member7.setSchoolNum("5657");

        em.persist(member);
        em.persist(member1);
        em.persist(member2);
        em.persist(member3);
        em.persist(member4);
        em.persist(member5);
        em.persist(member6);
        em.persist(member7);


        Long reserve = reserveService.reserve(member.getId(), "축구", "나와",12,Sport.SOCCER,
                LocalTime.of(20,30),
                LocalTime.of(22, 30),
                LocalDate.of(2000, 1, 3));


        Long participation = participationService.participation(member2.getId(), reserve);
        Long participation1 = participationService.participation(member3.getId(), reserve);
        Long participation2 = participationService.participation(member4.getId(), reserve);
        Long participation3 = participationService.participation(member5.getId(), reserve);



        participationService.cancelParticipation(participation1);
        participationService.cancelParticipation(participation2);


        em.flush();
        em.clear();

    }

    @Test
    public void 예약_취소() throws Exception{


        Member member = new Member();
        Member member1 = new Member();
        Member member2 = new Member();
        Member member3 = new Member();
        Member member4 = new Member();
        Member member5 = new Member();
        Member member6 = new Member();
        Member member7 = new Member();


        member.setName("김찬우");
        member1.setName("이훈일");
        member2.setName("이건희");
        member3.setName("조준장");
        member4.setName("왕세준");
        member5.setName("이기범");
        member6.setName("하재은");
        member7.setName("이종환");


        member.setPhoneNum("01082527933");
        member1.setPhoneNum("01082567865");
        member2.setPhoneNum("0108252678");
        member3.setPhoneNum("01025279678");
        member4.setPhoneNum("0108259787");
        member5.setPhoneNum("01082597871");
        member6.setPhoneNum("01082597873");
        member7.setPhoneNum("01082597875");

        member.setSchoolNum("12");
        member1.setSchoolNum("123");
        member2.setSchoolNum("1234");
        member3.setSchoolNum("123456");
        member4.setSchoolNum("1212345");
        member5.setSchoolNum("11235");
        member6.setSchoolNum("54664");
        member7.setSchoolNum("5657");

        em.persist(member);
        em.persist(member1);
        em.persist(member2);
        em.persist(member3);
        em.persist(member4);
        em.persist(member5);
        em.persist(member6);
        em.persist(member7);


        // 김찬우의 축구 방 만들기
        Long reserve = reserveService.reserve(member.getId(), "축구", "나와",12,Sport.SOCCER,
                LocalTime.of(20,30),
                LocalTime.of(22, 30),
                LocalDate.of(2000, 1, 3));


        // 이종환 농구 방 만듫기
        Long reserve1 = reserveService.reserve(member7.getId(), "농구", "나와",8,Sport.BASKETBALL,
                LocalTime.of(20,30),
                LocalTime.of(22, 30),
                LocalDate.of(2000, 1, 3));


        //축구 참가
        participationService.participation(member2.getId(),reserve);
        participationService.participation(member3.getId(),reserve);
        participationService.participation(member4.getId(),reserve);


        // 농구 참가
        participationService.participation(member5.getId(),reserve1);
        participationService.participation(member6.getId(),reserve1);


        // 축구방 제거
        reserveService.cancelReserve(reserve);

        //농구 방 제거
        reserveService.cancelReserve(reserve1);


    }

//    @Test
//    public void 예약업데이트() throws Exception{
//
//        Member member = new Member();
//        Member member1 = new Member();
//        Member member2 = new Member();
//        Member member3 = new Member();
//        Member member4 = new Member();
//        Member member5 = new Member();
//        Member member6 = new Member();
//        Member member7 = new Member();
//
//
//        member.setName("김찬우");
//        member1.setName("이훈일");
//        member2.setName("이건희");
//        member3.setName("조준장");
//        member4.setName("왕세준");
//        member5.setName("이기범");
//        member6.setName("하재은");
//        member7.setName("은혜");
//
//
//        member.setPhoneNum("01082527933");
//        member1.setPhoneNum("01082567865");
//        member2.setPhoneNum("0108252678");
//        member3.setPhoneNum("01025279678");
//        member4.setPhoneNum("0108259787");
//        member5.setPhoneNum("01082597871");
//        member6.setPhoneNum("01082597873");
//        member7.setPhoneNum("01082597875");
//
//        member.setSchoolNum("12");
//        member1.setSchoolNum("123");
//        member2.setSchoolNum("1234");
//        member3.setSchoolNum("123456");
//        member4.setSchoolNum("1212345");
//        member5.setSchoolNum("11235");
//        member6.setSchoolNum("54664");
//        member7.setSchoolNum("5657");
//
//        em.persist(member);
//        em.persist(member1);
//        em.persist(member2);
//        em.persist(member3);
//        em.persist(member4);
//        em.persist(member5);
//        em.persist(member6);
//        em.persist(member7);
//
//
//        Long reserve = reserveService.reserve(member.getId(), "축구", "나와",12,Sport.SOCCER,
//                LocalTime.of(20,30),
//                LocalTime.of(22, 30),
//                LocalDate.of(2000, 1, 3));
//
//
//        Long participation = participationService.participation(member2.getId(), reserve);
//        Long participation1 = participationService.participation(member3.getId(), reserve);
//        Long participation2 = participationService.participation(member4.getId(), reserve);
//        Long participation3 = participationService.participation(member5.getId(), reserve);
//
//
//        UpdateReserveDto updateReserveDto = new UpdateReserveDto(Sport.SOCCER, LocalDate.of(2000, 1, 3),
//                LocalTime.of(20,30),
//                LocalTime.of(22, 30),
//                "ㅅㅂ","하기싫다");
//
//        reserveService.updateReserve(reserve,updateReserveDto);
//
//
//
//    }

    @Test
    public void 오늘_운동예약_보여주기 () throws Exception{

        //given

        Member member = new Member();
        Member member1 = new Member();
        Member member2 = new Member();
        Member member3 = new Member();
        Member member4 = new Member();
        Member member5 = new Member();
        Member member6 = new Member();
        Member member7 = new Member();


        member.setName("김찬우");
        member1.setName("이훈일");
        member2.setName("이건희");
        member3.setName("조준장");
        member4.setName("왕세준");
        member5.setName("이기범");
        member6.setName("하재은");
        member7.setName("이종환");


        member.setPhoneNum("01082527933");
        member1.setPhoneNum("01082567865");
        member2.setPhoneNum("0108252678");
        member3.setPhoneNum("01025279678");
        member4.setPhoneNum("0108259787");
        member5.setPhoneNum("01082597871");
        member6.setPhoneNum("01082597873");
        member7.setPhoneNum("01082597875");

        member.setSchoolNum("12");
        member1.setSchoolNum("123");
        member2.setSchoolNum("1234");
        member3.setSchoolNum("123456");
        member4.setSchoolNum("1212345");
        member5.setSchoolNum("11235");
        member6.setSchoolNum("54664");
        member7.setSchoolNum("5657");

        em.persist(member);
        em.persist(member1);
        em.persist(member2);
        em.persist(member3);
        em.persist(member4);
        em.persist(member5);
        em.persist(member6);
        em.persist(member7);


        Long reserve = reserveService.reserve(member.getId(), "축구", "나와",12,Sport.SOCCER,
                LocalTime.of(20,30),
                LocalTime.of(22, 30),
                LocalDate.of(2000, 1, 3));

        Long reserve1 = reserveService.reserve(member1.getId(), "농구", "나와1",12,Sport.BASKETBALL,
                LocalTime.of(20,30),
                LocalTime.of(22, 30),
                LocalDate.of(2000, 1, 4));

        Long reserve2 = reserveService.reserve(member2.getId(), "농구", "나와2",12,Sport.BASKETBALL,                LocalTime.of(20,30),
                LocalTime.of(22, 30),
                LocalDate.of(2000, 1, 5));

        Long reserve3 = reserveService.reserve(member1.getId(), "축구", "나와3",12,Sport.SOCCER,
                LocalTime.of(20,30),
                LocalTime.of(22, 30),
                LocalDate.of(2000, 1, 3));


        participationService.participation(member3.getId(),reserve);
        participationService.participation(member6.getId(),reserve1);
        participationService.participation(member4.getId(),reserve2);
        participationService.participation(member5.getId(),reserve3);


        List<Reserve> reserves = reserveService.todayMatch(LocalDate.of(2000, 1, 3));

        System.out.println(" ======================================================================= " );



        for (Reserve result : reserves) {
            System.out.println(" ======================================================================= " );
            System.out.println("result = " + result.getTitle());
        }

        String day = "2000-01-03";
        String sport = "SOCCER";
        LocalDate date = LocalDate.parse(day, DateTimeFormatter.ISO_DATE);
        Sport sport1 =Sport.valueOf(sport);

        System.out.println("sport1 = " + sport1);
        System.out.println("date = " + date);

        System.out.println("sport1.getClass() = " + sport1.getClass().getName());
        System.out.println("date.getClass().getName() = " + date.getClass().getName());


    }

    @Test
    public void 날짜_스포츠_입력하면_경기보여주기() throws Exception{

        //given

        Member member = new Member();
        Member member1 = new Member();
        Member member2 = new Member();
        Member member3 = new Member();
        Member member4 = new Member();
        Member member5 = new Member();
        Member member6 = new Member();
        Member member7 = new Member();


        member.setName("김찬우");
        member1.setName("이훈일");
        member2.setName("이건희");
        member3.setName("조준장");
        member4.setName("왕세준");
        member5.setName("이기범");
        member6.setName("하재은");
        member7.setName("이종환");


        member.setPhoneNum("01082527933");
        member1.setPhoneNum("01082567865");
        member2.setPhoneNum("0108252678");
        member3.setPhoneNum("01025279678");
        member4.setPhoneNum("0108259787");
        member5.setPhoneNum("01082597871");
        member6.setPhoneNum("01082597873");
        member7.setPhoneNum("01082597875");

        member.setSchoolNum("12");
        member1.setSchoolNum("123");
        member2.setSchoolNum("1234");
        member3.setSchoolNum("123456");
        member4.setSchoolNum("1212345");
        member5.setSchoolNum("11235");
        member6.setSchoolNum("54664");
        member7.setSchoolNum("5657");

        em.persist(member);
        em.persist(member1);
        em.persist(member2);
        em.persist(member3);
        em.persist(member4);
        em.persist(member5);
        em.persist(member6);
        em.persist(member7);


        Long reserve = reserveService.reserve(member.getId(), "1", "나와",12,Sport.SOCCER,
                LocalTime.of(22,30),
                LocalTime.of(20, 30),
                LocalDate.of(2000, 1, 3));

        Long reserve1 = reserveService.reserve(member1.getId(), "2", "나와1",12,Sport.SOCCER,
                LocalTime.of(20,30),
                LocalTime.of(18, 30),
                LocalDate.of(2000, 1, 3));

        Long reserve2 = reserveService.reserve(member2.getId(), "3", "나와2",12,Sport.SOCCER,
                LocalTime.of(20,30),
                LocalTime.of(18, 29),
                LocalDate.of(2000, 1, 5));

        Long reserve3 = reserveService.reserve(member1.getId(), "4", "나와3",12,Sport.SOCCER,
                LocalTime.of(20,30),
                LocalTime.of(18, 29),
                LocalDate.of(2000, 1, 3));


        participationService.participation(member3.getId(),reserve);
        participationService.participation(member6.getId(),reserve1);
        participationService.participation(member4.getId(),reserve2);
        participationService.participation(member5.getId(),reserve3);


        List<Reserve> reserves = reserveService.sportDate(LocalDate.of(2000, 1, 3), Sport.SOCCER);

        for (Reserve result : reserves) {
            System.out.println("==================================== ");
            System.out.println("result = " + result.getTitle());

        }


    }



}