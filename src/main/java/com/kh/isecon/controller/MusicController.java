package com.kh.isecon.controller;

import com.kh.isecon.dao.MusicDao;
import com.kh.isecon.dao.PlayListDao;
import com.kh.isecon.vo.InsertPlayListVo;
import com.kh.isecon.vo.MusicVo;
import com.kh.isecon.vo.PlayListVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("music/{plname}/{uno}")
    public ResponseEntity<List<MusicVo>> playListMusicView(@PathVariable String plname, @PathVariable int uno){
        MusicDao dao = new MusicDao();
        List<MusicVo> list = dao.playListMusicSelect(plname,uno);
        return ResponseEntity.ok(list);
    }
    @GetMapping("/myplaylist/{uno}")
    public ResponseEntity<List<PlayListVo>> myPlayListAllView(@PathVariable int uno){
        PlayListDao dao = new PlayListDao();
        List<PlayListVo> list = dao.usersPlayListNameSelect(uno);
//        view에서 현재 보고있던 음악의 정보를 저장해놔 화면에 띄워주고
//        view끼리 넘겨 url이 바뀌어도 그 이전에 보던 정보 (유튜브 화면)이
//        띄워지게 하기 (useState 사용!)
        return ResponseEntity.ok(list);
    }
    @PostMapping("insertpl")
    public ResponseEntity<Boolean> playListInsert(@RequestBody InsertPlayListVo vo){
        PlayListDao dao = new PlayListDao();
        List<Integer> mnoList = vo.getMnoList();
        int uno = vo.getUno();
        String plname = vo.getPlname();
        boolean isTrue = dao.playListInsert(mnoList,uno,plname);
        return ResponseEntity.ok(isTrue);
    }
    @PostMapping("plnameup")
    public ResponseEntity<Boolean> plNameUpdate(@RequestBody MusicVo vo){
        PlayListDao dao = new PlayListDao();
        String oriplName = vo.getMname(); // 기존이름 mname에 넣어오기
        String newplName = vo.getSurl(); // 새 이름 surl에 넣어오기
        int uno = vo.getMno(); // uno mno에 넣어오기
        boolean isTrue = dao.playListUpdatePlname(oriplName,newplName,uno);
        return ResponseEntity.ok(isTrue);
    }

}
