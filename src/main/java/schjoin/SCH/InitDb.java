package schjoin.SCH;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import schjoin.SCH.domain.Member;
import schjoin.SCH.domain.Participation;
import schjoin.SCH.domain.Reserve;
import schjoin.SCH.domain.Sport;
import schjoin.SCH.service.ParticipationService;
import schjoin.SCH.service.ReserveService;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Component
@RequiredArgsConstructor
public class InitDb {

    private final InitService initService;


    @PostConstruct
    public void init() {
        initService.dbInit1();
    }


    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitService {

        private final EntityManager em;


        public void dbInit1() {

            Member member = new Member();
            Member member1 = new Member();



            member.setName("김찬우");
            member1.setName("이훈일");


            member.setPhoneNum("01082527933");
            member1.setPhoneNum("01082567865");

            member.setSchoolNum("12");
            member1.setSchoolNum("123");

            member.setPassword("123jhu");
            member1.setPassword("asdsdwd");

            member.setLoginId("1234");
            member1.setLoginId("123아4");

            em.persist(member);
            em.persist(member1);


            Reserve reserve = new Reserve();
            reserve.setMember(member);
            reserve.setSport(Sport.SOCCER);
            reserve.setReserveDate(LocalDate.of(2000, 1, 3));
            reserve.setStartT( LocalTime.of(18, 30));
            reserve.setEndT( LocalTime.of( 20, 30));
            reserve.setNowReserveT(LocalDateTime.now());
            reserve.setTitle("축구하자 축구");
            reserve.setExplanation("축구화가져와");
            reserve.setCurrentNum(2);
            reserve.setRecruitmentNum(12);

            Reserve reserve1 = new Reserve();
            reserve1.setMember(member1);
            reserve1.setSport(Sport.SOCCER);
            reserve1.setReserveDate(LocalDate.of(2000, 1, 3));
            reserve1.setStartT( LocalTime.of(18, 19));
            reserve1.setEndT( LocalTime.of( 20, 30));
            reserve1.setNowReserveT(LocalDateTime.now());
            reserve1.setTitle("축구하자");
            reserve1.setExplanation("축구");
            reserve1.setCurrentNum(2);
            reserve1.setRecruitmentNum(12);

            em.persist(reserve);
            em.persist(reserve1);








        }


    }


}







