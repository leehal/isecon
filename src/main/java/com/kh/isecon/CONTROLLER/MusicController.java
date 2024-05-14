package com.kh.isecon.CONTROLLER;

import com.kh.isecon.DAO.MusicDao;
import com.kh.isecon.DAO.PlayListDao;
import com.kh.isecon.VO.MusicVo;
import com.kh.isecon.VO.PlayListVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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


}
