package com.kh.isecon.controller;

import com.kh.isecon.dao.UsersDao;
import com.kh.isecon.vo.UsersVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/isecon/users")
@RequiredArgsConstructor
public class UsersController {
    @GetMapping("/userinfo") // 마이페이지
    public ResponseEntity<UsersVo> userSelect(@RequestParam("uno") int uno) {
        UsersDao dao = new UsersDao();
        return ResponseEntity.ok(dao.userInfo(uno));
    }

    @PostMapping("/userSignup") // 회원가입 정보 저장
    public ResponseEntity<Boolean> signupInsert(@RequestBody UsersVo vo) {
        UsersDao dao = new UsersDao();
        boolean isTrue = dao.UsersInsert(vo);
        return ResponseEntity.ok(isTrue);
    }
    @DeleteMapping("/userDelete/{uno}") // 회원삭제
    public ResponseEntity<Boolean> userDelete(@PathVariable int uno) {
        UsersDao dao = new UsersDao();
        boolean isDeleted = dao.UsersDelete(uno);
        return ResponseEntity.ok(isDeleted);
    }
    @PostMapping("/userupdate") // 사용자 정보 업데이트
    public ResponseEntity<Boolean> userUpdate(@RequestBody UsersVo vo) {
        UsersDao dao = new UsersDao();
        boolean isUpDate = dao.UserUpDate(vo);
        return ResponseEntity.ok(isUpDate);
    }
    @PostMapping("/userLogin") // 로그인
    public ResponseEntity<Integer> loginCheck(@RequestBody UsersVo vo) {
        UsersDao dao = new UsersDao();
        int isLog = dao.LoginCheck(vo);
        return ResponseEntity.ok(isLog);
    }
    @PostMapping("/checkDuplicate") // 중복확인
    public ResponseEntity<Boolean> checkDuplicate(@RequestBody UsersVo vo) {
        UsersDao dao = new UsersDao();
        return ResponseEntity.ok(dao.checkUser(vo));
    }
}