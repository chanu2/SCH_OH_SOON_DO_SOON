package schjoin.SCH.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import schjoin.SCH.domain.User;
import schjoin.SCH.dto.AddUserDto;
import schjoin.SCH.repository.UserRepository;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    //회원가입
    @Transactional
    public Long createMember(AddUserDto addUserDto){
        User user = User.addUser(addUserDto.getName(), addUserDto.getSchoolNum(), addUserDto.getPhoneNum(), addUserDto.getLoginId(), addUserDto.getPassword());
        userRepository.save(user);
        return user.getId();
    }


    //회원 한명 조회
    public User findOne(Long memberId){
        return userRepository.findOne(memberId);
    }
}