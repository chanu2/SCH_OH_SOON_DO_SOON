package schjoin.SCH.dto;

import lombok.Getter;
import lombok.Setter;
import schjoin.SCH.domain.Participation;

@Getter
@Setter
public class ReserveMemberInfoDto {

    private String name;
    private String schoolNum;


    public ReserveMemberInfoDto(Participation participation){

        name = participation.getMember().getName();
        schoolNum = participation.getMember().getSchoolNum();
    }
}
