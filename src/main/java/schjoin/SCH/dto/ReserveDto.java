package schjoin.SCH.dto;

import lombok.Getter;
import schjoin.SCH.domain.Gender;
import schjoin.SCH.domain.Sport;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
public class ReserveDto {

    private Long id;

    private Sport sport;

    private LocalDate reserveDate;
    private LocalTime startT;
    private LocalTime endT;

    private String title;
    private String explanation;
    private Integer currentNum;
    private Integer recruitmentNum;



    private String place;

    private Gender gender;

    public ReserveDto(Long id, Sport sport, LocalDate reserveDate, LocalTime startT, LocalTime endT, String title, String explanation, Integer currentNum, Integer recruitmentNum, String place, Gender gender) {
        this.id = id;
        this.sport = sport;
        this.reserveDate = reserveDate;
        this.startT = startT;
        this.endT = endT;
        this.title = title;
        this.explanation = explanation;
        this.currentNum = currentNum;
        this.recruitmentNum = recruitmentNum;
        this.place = place;
        this.gender = gender;
    }
}
