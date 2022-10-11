package schjoin.SCH.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import schjoin.SCH.domain.Participation;
import schjoin.SCH.domain.Reserve;
import schjoin.SCH.dto.ReserveInfoDto;
import schjoin.SCH.repository.ParticipationRepository;
import schjoin.SCH.service.ParticipationService;
import schjoin.SCH.service.ReserveService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class ParticipationController {

    private final ParticipationService participationService;

    private final ReserveService reserveService;



    @GetMapping("participations/v3/{reserveId}/reserve-info")
    public List<ReserveInfoDto> reserve3(@PathVariable("reserveId") Long reserveId){
        List<Participation> participations = participationService.reserveInfo(reserveId);
        List<ReserveInfoDto> result = participations.stream().map(p -> new ReserveInfoDto(p)).collect(Collectors.toList());
        return result;


    }

}
