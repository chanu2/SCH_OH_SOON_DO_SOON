package schjoin.SCH.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import schjoin.SCH.dto.AddUserDto;
import schjoin.SCH.response.DefaultRes;
import schjoin.SCH.response.StatusCode;
import schjoin.SCH.service.UserService;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final UserService userService;


    @PostMapping("users/creation")
    public ResponseEntity createMember(@RequestBody AddUserDto addUserDto){
        Long memberId = userService.createMember(addUserDto);

        return memberId != null ?
                new ResponseEntity(DefaultRes.res(StatusCode.OK, "회원가입 완료"), HttpStatus.OK) :
                new ResponseEntity(DefaultRes.res(StatusCode.BAD_REQUEST, "잘못된 요청"), HttpStatus.OK);
    }



}
