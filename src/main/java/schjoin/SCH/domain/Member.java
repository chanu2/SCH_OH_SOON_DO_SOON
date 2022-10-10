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
    private String password;

    private String name;
    private String schoolNum;
    private String phoneNum;

    public Member() {
    }

    //    @OneToMany(mappedBy = "member")
//    private List<Reserve> reserves = new ArrayList<>();
//
//    @OneToMany(mappedBy = "member")
//    private List<Participation> participationMembers = new ArrayList<>();

}