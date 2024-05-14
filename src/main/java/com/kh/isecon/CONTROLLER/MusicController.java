package com.kh.isecon.CONTROLLER;

import com.kh.isecon.DAO.MusicDao;
import com.kh.isecon.VO.MusicVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/isecon/consert")
@RequiredArgsConstructor
public class MusicController {

    @GetMapping("/allmusic")
    public ResponseEntity<List<MusicVo>> allMusicView(){
        MusicDao dao = new MusicDao();
        List<MusicVo> list = dao.musicSelectAll();
        return ResponseEntity.ok(list);
    }
}
