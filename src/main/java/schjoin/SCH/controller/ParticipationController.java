package schjoin.SCH.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import schjoin.SCH.domain.Participation;
import schjoin.SCH.domain.Reserve;
import schjoin.SCH.dto.ParticipationSportDto;
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


    //참여 하기

    @PostMapping("participation/v1/participation-sport")
    public Long participateSport(@RequestBody @Validated ParticipationSportDto participationSportDto){
        Long participation = participationService.participation(participationSportDto);
        return participation;
    }

    // 참여 취소
    @DeleteMapping("participation/v1/participation-cancel/{participationId}")
    public String cancelParticipation(@PathVariable Long participationId){

         participationService.cancelParticipation(participationId);

        return "ok";
    }




    //한경기 모든 정보 보여주기

    @GetMapping("participations/v3/{reserveId}/reserve-info")
    public List<ReserveInfoDto> reserve3(@PathVariable("reserveId") Long reserveId){
        List<Participation> participations = participationService.reserveInfo(reserveId);
        List<ReserveInfoDto> result = participations.stream().map(p -> new ReserveInfoDto(p)).collect(Collectors.toList());
        return result;

    }






}
