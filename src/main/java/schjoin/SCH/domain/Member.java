package schjoin.SCH.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String loginId;


    private String name;
    private String schoolNum;
    private String phoneNum;

    public Member() {
    }

    //==생성 메서드==//
    public static Member addMember(String name,String schoolNum,String phoneNum){
        Member member= new Member();
        member.setName(name);
        member.setSchoolNum(schoolNum);
        member.setPhoneNum(phoneNum);
        return member;
    }

    //    @OneToMany(mappedBy = "member")
//    private List<Reserve> reserves = new ArrayList<>();
//
//    @OneToMany(mappedBy = "member")
//    private List<Participation> participationMembers = new ArrayList<>();

}