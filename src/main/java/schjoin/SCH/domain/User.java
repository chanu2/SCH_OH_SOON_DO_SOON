package schjoin.SCH.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class User {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String loginId;
    private String password;

    private String name;
    private String schoolNum;
    private String phoneNum;

    public User() {
    }

    //==생성 메서드==//
    public static User addUser(String name, String schoolNum, String phoneNum, String loginId, String password){
        User user = new User();
        user.setName(name);
        user.setSchoolNum(schoolNum);
        user.setPhoneNum(phoneNum);
        user.setLoginId(loginId);
        user.setPassword(password);
        return user;
    }

}