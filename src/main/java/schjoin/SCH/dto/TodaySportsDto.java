package schjoin.SCH.dto;

import lombok.Getter;
import schjoin.SCH.domain.Reserve;
import schjoin.SCH.domain.Sport;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
public class TodaySportsDto {


    private Sport sport;

    private LocalDate reserveDate;

    private LocalTime startT;

    private LocalTime endT;


    private String title;
    private String explanation;

    private Integer currentNum;

    private Integer recruitmentNum;

    public TodaySportsDto(Reserve reserve){
        sport=reserve.getSport();
        reserveDate =reserve.getReserveDate();
        startT = reserve.getStartT();
        endT = reserve.getEndT();
        title = reserve.getTitle();
        explanation = reserve.getExplanation();
        currentNum = reserve.getCurrentNum();
        recruitmentNum = reserve.getRecruitmentNum();

    }


}
