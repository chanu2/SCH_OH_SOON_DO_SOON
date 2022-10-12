package schjoin.SCH.dto;


import lombok.Getter;

@Getter
public class ParticipationSportDto {

    private Long memberId;
    private Long reserveId;

    public ParticipationSportDto(Long memberId, Long reserveId) {
        this.memberId = memberId;
        this.reserveId = reserveId;
    }
    public  ParticipationSportDto(){

    }

}
