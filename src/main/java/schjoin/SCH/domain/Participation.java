package schjoin.SCH.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Participation{

    @Id @GeneratedValue
    @Column(name = "participation_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reserve_id")
    private Reserve reserve;

    //==생성 메서드==//
    public static Participation createParticipation(Member member,Reserve reserve){
        Participation participation = new Participation();
        participation.setMember(member);
        //reserve.addParticipation(participation);
        //participation.setReserve(reserve); // 연관 관계 메서드 사용?
        return participation;
    }

    //==비즈니스 로직==//
}