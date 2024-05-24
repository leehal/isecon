package com.kh.isecon.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PlayListUpdateVo {
    private String oldPlName;
    private String newPlName;
    private int uno;
    private List<Integer> mnoList;
}
