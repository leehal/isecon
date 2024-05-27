package com.kh.isecon.controller;


import com.kh.isecon.dao.UsersDao;
import com.kh.isecon.dao.WeatherDao;
import com.kh.isecon.vo.UsersVo;
import com.kh.isecon.vo.WeatherVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/isecon/weather")
@RequiredArgsConstructor


public class WeatherController {

    @PostMapping("/weatherupdate") // 방송 정보 수정하기
    public ResponseEntity<Boolean> weatherUpdate(@RequestBody WeatherVo vo) {
        WeatherDao dao = new WeatherDao();
        boolean whUpDate = dao.WeatherUpdate(vo);
        return ResponseEntity.ok(whUpDate);
    }
    @GetMapping("/weatherall") // 방송 정보 수정하기
    public ResponseEntity<List<WeatherVo>> weatherAll() {
        WeatherDao dao = new WeatherDao();
        List<WeatherVo> list = dao.weatherAll();
        return ResponseEntity.ok(list);
    }
}
