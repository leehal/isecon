package com.kh.isecon.CONTROLLER;

import com.kh.isecon.DAO.UsersDao;
import com.kh.isecon.VO.UsersVo;
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
    @GetMapping("/userinfo") // 유저 정보 보여주기
    public ResponseEntity<UsersVo> userSelect(@RequestParam ("uno") int uno){
        UsersDao dao = new UsersDao();
        return ResponseEntity.ok(dao.userInfo(uno));
    }
    
}
