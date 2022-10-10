package schjoin.SCH.dto;


import lombok.Getter;
import lombok.Setter;
import schjoin.SCH.domain.Sport;

import java.time.LocalDateTime;

@Getter
@Setter
public class ReserveDto {



    private Long id;

    private Sport sport;

    private LocalDateTime reserveDate;
    private LocalDateTime startT;
    private LocalDateTime endT;

    private Integer recruitmentNum;

    private String title;
    private String explanation;


}
