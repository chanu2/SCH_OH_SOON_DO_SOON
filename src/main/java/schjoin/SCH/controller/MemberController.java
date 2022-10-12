package schjoin.SCH.controller;


import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import schjoin.SCH.dto.AddMemberDto;
import schjoin.SCH.dto.ParticipationSportDto;
import schjoin.SCH.response.DefaultRes;
import schjoin.SCH.response.StatusCode;
import schjoin.SCH.service.MemberService;

import javax.swing.plaf.PanelUI;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;


    @PostMapping("members/create-member")
    public ResponseEntity createMember(@RequestBody AddMemberDto addMemberDto){
        Long memberId = memberService.createMember(addMemberDto);

        return memberId != null ?
                new ResponseEntity(DefaultRes.res(StatusCode.OK, "회원가입 완료"), HttpStatus.OK) :
                new ResponseEntity(DefaultRes.res(StatusCode.BAD_REQUEST, "잘못된 요청"), HttpStatus.OK);
    }



}
