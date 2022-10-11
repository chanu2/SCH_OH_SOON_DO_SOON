package schjoin.SCH.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import schjoin.SCH.domain.Sport;

import javax.swing.plaf.PanelUI;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
public class CreateReserveDto {

    private Long memberId;

    private String title;

    private String explanation;

    private Integer recruitmentNum;
    private Sport sport;

    private LocalTime endT;

    private LocalTime startT;

    private LocalDate reserveDate;

    public CreateReserveDto(Long memberId, String title, String explanation, Integer recruitmentNum, Sport sport, LocalTime endT, LocalTime startT, LocalDate reserveDate) {
        this.memberId = memberId;
        this.title = title;
        this.explanation = explanation;
        this.recruitmentNum = recruitmentNum;
        this.sport = sport;
        this.endT = endT;
        this.startT = startT;
        this.reserveDate = reserveDate;
    }
    public CreateReserveDto(){

    }
}