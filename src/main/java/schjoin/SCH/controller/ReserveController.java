package schjoin.SCH.controller;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import schjoin.SCH.domain.Reserve;
import schjoin.SCH.domain.Sport;
import schjoin.SCH.dto.CreateReserveDto;
import schjoin.SCH.dto.ReserveDto;
import schjoin.SCH.dto.SimpleReserveDto;
import schjoin.SCH.dto.UpdateReserveDto;
import schjoin.SCH.service.ReserveService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class ReserveController {

    private final ReserveService reserveService;



    // 경기 생성
    @PostMapping("reserves/v1/create")
    public Long createReserve(@RequestBody @Validated CreateReserveDto createReserveDto){

        Long reserve = reserveService.reserve(createReserveDto);

        return reserve;
    }



    //경기 업데이트
    @PostMapping("reserves/v1/edit/{reserveId}")
    public String updateReserve(@PathVariable Long reserveId, @RequestBody @Validated UpdateReserveDto dto){

        reserveService.updateReserve(reserveId,dto);

        return "ok";
    }


    // 원하는 날짜,스포츠 정렬해서 경기들 보여 주기
    @GetMapping("reserves/date")
    public SportDateResponse showSports(@RequestParam(name = "day") String day,@RequestParam(name = "sport") String sport){
        LocalDate date = LocalDate.parse(day, DateTimeFormatter.ISO_DATE);
        Sport sport1 =Sport.valueOf(sport);

        List<Reserve> reserves = reserveService.sportDate(date, sport1);
        List<SimpleReserveDto> collect = reserves.stream().map(s -> new SimpleReserveDto(s)).collect(Collectors.toList());

        return new SportDateResponse(collect);

    }

    @Data
    @AllArgsConstructor
    static class SportDateResponse<T>{
        private T data;
    }

    @Data
    @AllArgsConstructor
    static class SportDateDto{
        private LocalDate day;
        private Sport sport;
    }


    // 경기 삭제
    @DeleteMapping("reserves/v1/delete/{reserveId}")
    public String deleteReserve(@PathVariable Long reserveId){

        reserveService.cancelReserve(reserveId);

        return "ok";
    }





    
}
