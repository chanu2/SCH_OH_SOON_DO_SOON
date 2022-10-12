package schjoin.SCH.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import schjoin.SCH.domain.Gender;
import schjoin.SCH.domain.Reserve;
import schjoin.SCH.domain.Sport;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
public class UpdateReserveDto {

    private Sport sport;

    private LocalDate reserveDate;
    private LocalTime startT;
    private LocalTime endT;

    private String title;
    private String explanation;

    private String place;
    private Gender gender;

    public UpdateReserveDto(Sport sport, LocalDate reserveDate, LocalTime starT, LocalTime endT, String title, String explanation,String place,Gender gender) {
        this.sport = sport;
        this.reserveDate = reserveDate;
        this.startT = starT;
        this.endT = endT;
        this.title = title;
        this.explanation = explanation;
        this.place = place;
        this.gender = gender;
    }

    public UpdateReserveDto(){

    }
}
