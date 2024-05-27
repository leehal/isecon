package com.kh.isecon.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WeatherVo {
    private int wno;
    private int uno;
    private Date wdate;
    private int onair;
}
